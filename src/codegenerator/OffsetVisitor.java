package codegenerator;

import ast.definitions.FuncDefinition;
import ast.definitions.VarDefinition;
import ast.statements.Statement;
import ast.types.FunctionType;
import ast.types.RecordField;
import ast.types.Struct;
import visitor.AbstractVisitor;

/**
 * Calculate offset of local, global, parameters and record fields
 */
public class OffsetVisitor extends AbstractVisitor<Void, Void> {

    private int globalOffsetSum = 0;

    /**
     * Compute offsets of the fields in a struct
     * @param struct
     * @param param
     * @return
     */
    @Override
    public Void visit(Struct struct, Void param) {
        // traverse because it is not a leaf node
        super.visit(struct, param);
        // accumulator of offsets. the first field is always offset 0
        int offsetSum = 0;
        // foreach recordfield, set its offset and update accumulator
        for (RecordField recordField: struct.getFields()){
            recordField.setOffset(offsetSum);
            offsetSum += recordField.getType().numberOfBytes();
        }
        return null;
    }

    /**
     * Compute local variables
     * @param funcDefinition
     * @param param
     * @return
     */
    @Override
    public Void visit(FuncDefinition funcDefinition, Void param) {
        // traverse because it is not a leaf node: traverse statements and definitions messes the offset??
        super.visit(funcDefinition, param);
        // accumulator for local variables offsets
        int localOffsetSum = 0;
        // offsets of local variables => add type.numBytes to accumulator, set offset to -accumulator
        // local variables are - sum of ... and have to skip themselves
        for (VarDefinition varDefinition : funcDefinition.getDefinitionList()){
            localOffsetSum += varDefinition.getType().numberOfBytes();
            varDefinition.setOffset(-localOffsetSum); //store the sign
        }
        return null;
    }

    /**
     * Compute global variables
     * @param varDefinition
     * @param param
     * @return
     */
    @Override
    public Void visit(VarDefinition varDefinition, Void param) {
//        // traverse because is not a leaf node
        varDefinition.getType().accept(this, param);
        // check if it is a global variable with its scope
        if (varDefinition.getScope() == 0){
            // global variables always start in 0
            varDefinition.setOffset(globalOffsetSum);
            // increase accumulator
            globalOffsetSum += varDefinition.getType().numberOfBytes();
        }
        return null;
    }

    /**
     * Compute the offsets of parameters
     * @param functionType
     * @param param
     * @return
     */
    @Override
    public Void visit(FunctionType functionType, Void param) {
        // traverse because it is not a leaf node
        functionType.getReturnType().accept(this, param); // if traverse the definition messes the offset??
        // accumulator for the parameters offsets
        int parametersOffsetSum = 0;
        // start adding from the last parameter: right to left. Parameters are inserted in the stack
        // from left to right, so the last parameter is the one above all (next to the control)
        for (int i = functionType.getArguments().size()-1; i >= 0; i--){
            VarDefinition parameter = functionType.getArguments().get(i);
            // do not have to skip its size; add 4 because of the size of the control
            parameter.setOffset(4+parametersOffsetSum);
            parametersOffsetSum += parameter.getType().numberOfBytes();
        }
        return null;
    }
}

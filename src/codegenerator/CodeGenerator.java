package codegenerator;

import ast.ASTNode;
import ast.expressions.CharLiteral;
import ast.expressions.DoubleLiteral;
import ast.expressions.IntLiteral;
import ast.types.Char;
import ast.types.Int;
import ast.types.Real;
import ast.types.Type;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeGenerator {

    String sourceFile;
    String outFile;
    PrintWriter out;

    int labels;
    public CodeGenerator(String input, String output){
        labels = 0;
        try {
            out = new PrintWriter(output);
            this.outFile = output;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.sourceFile = input;
        writeSource();
    }

    public void writeSource(){
        out.write("#source \"" + sourceFile + "\"\n");
        out.flush();
    }

    public String nextLabel(){
        String ret = "label" + labels;
        labels++;
        return ret;
    }

    public void comment(String content){
        out.write(content);
        out.flush();
    }

    public void pushb(Type type, ASTNode node){
        CharLiteral literal = (CharLiteral) node;
        if (String.valueOf(type.suffix()).equals("b")){
            out.write("\tpushb " + (int)literal.getValue() + "\n");
        }
        else if (String.valueOf(type.suffix()).equals("i")){
            out.write("\tpushi " + (int)literal.getValue() + "\n");
        }
        else if (String.valueOf(type.suffix()).equals("f")){
            out.write("\tpushf " + (double)literal.getValue() + "\n");
        }
        out.flush();
    }

    public void pushi(int i){
        out.write("\tpushi " + i + "\n");
        out.flush();
    }

    public void pushf(double d){
        out.write("\tpushf " + d + "\n");
        out.flush();
    }

    public void pusha(int i){
        out.write("\tpusha " + i + "\n");
        out.flush();
    }

    public void pushBP(){
        out.write("\tpush bp \n");
        out.flush();
    }

    public void add(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tadd" + suffix + "\n");
        out.flush();
    }

    public void sub(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tsub" + suffix + "\n");
        out.flush();
    }

    public void mul(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tmul" + suffix + "\n");
        out.flush();
    }

    public void div(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tdiv" + suffix + "\n");
        out.flush();
    }

    public void mod(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tmod" + suffix + "\n");
        out.flush();
    }

    public void and(){
        out.write("\tand\n");
        out.flush();
    }

    public void or(){
        out.write("\tor\n");
        out.flush();
    }

    public void greaterThan(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tgt" + suffix + "\n");
        out.flush();
    }

    public void lowerThan(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tlt" + suffix + "\n");
        out.flush();
    }

    public void greaterOrEqualTo(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tge" + suffix + "\n");
        out.flush();
    }

    public void lowerOrEqualTo(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tle" + suffix + "\n");
        out.flush();
    }

    public void equalTo(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\teq" + suffix + "\n");
        out.flush();
    }

    public void notEqualTo(Type type){
        String suffix = type.suffix() == 'b' ? "" : String.valueOf(type.suffix());
        out.write("\tne" + suffix + "\n");
        out.flush();
    }

    public void load(Type type){
        String suffix = String.valueOf(type.suffix());
        out.write("\tload" + suffix + "\n");
        out.flush();
    }

    public void convertTo(Type typeFrom, Type typeTo){
        if(typeFrom.equals(Int.getInstance())){
            if(typeTo.equals(Real.getInstance())){
                out.write( "\ti2f\n");
            }else if(typeTo.equals(Char.getInstance())){
                out.write( "\ti2b\n");
            }
        }
        if(typeFrom.equals(Real.getInstance())){
            if(typeTo.equals(Int.getInstance())){
                out.write( "\tf2i\n");
            }else if(typeTo.equals(Char.getInstance())){
                out.write( "\tf2i\n" + "\ti2b\n");
            }
        }
        if(typeFrom.equals(Char.getInstance())){
            if(typeTo.equals(Int.getInstance())){
                out.write( "\tb2i\n");
            }else if(typeTo.equals(Real.getInstance())){
                out.write( "\tb2i\n" + "\ti2f\n");
            }
        }
        out.flush();
    }

    public void not(){
        out.write("\tnot\n");
        out.flush();
    }

    public void in(Type type){
        String suffix = String.valueOf(type.suffix());
        out.write("\tin" + suffix + "\n");
        out.flush();
    }

    public void out(Type type){
        String suffix = String.valueOf(type.suffix());
        out.write("\tout" + suffix + "\n");
        out.flush();
    }

    public void store(Type type){
        String suffix = String.valueOf(type.suffix());
        out.write("\tstore" + suffix + "\n");
        out.flush();
    }

    public void call(String name){
        out.write("\tcall " + name + "\n");
        out.flush();
    }

    public void halt(){
        out.write("\thalt\n");
        out.flush();
    }

    public void ret(int bytesReturn, int bytesLocals, int bytesParams){
        out.write("\tret " + bytesReturn + ", " + bytesLocals + ", " + bytesParams + "\n");
        out.flush();
    }

    public void jz(String label){
        out.write("\tjz " + label + "\n");
        out.flush();
    }

    public void jnz(String label){
        out.write("\tjnz " + label + "\n");
        out.flush();
    }

    public void jmp(String label){
        out.write("\tjmp " + label + "\n");
        out.flush();
    }

    public void pop(Type type){
        out.write("\tpop" + type.suffix() + "\n");
        out.flush();
    }

    public void dup(Type type){
        out.write("\tdup" + type.suffix() + "\n");
        out.flush();
    }

    public void line(int line){
        out.write("\n#line " + line + "\n");
        out.flush();
    }

}

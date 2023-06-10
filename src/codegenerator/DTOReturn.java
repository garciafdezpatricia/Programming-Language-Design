package codegenerator;

public class DTOReturn {

    private int bytesLocals;
    private int bytesParams;
    private int bytesReturn;

    public DTOReturn(int locals, int params, int ret){
        bytesLocals = locals;
        bytesParams = params;
        bytesReturn = ret;
    }

    public int getBytesLocals() {
        return bytesLocals;
    }

    public int getBytesParams() {
        return bytesParams;
    }

    public int getBytesReturn() {
        return bytesReturn;
    }
}

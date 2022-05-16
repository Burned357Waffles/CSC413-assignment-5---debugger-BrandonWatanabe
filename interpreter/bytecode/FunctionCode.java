package interpreter.bytecode;

import interpreter.VirtualMachine;

public class FunctionCode extends ByteCode
{
    private String byte_code;
    private String name;
    private int offset;

    public FunctionCode(){}

    @Override
    public void init(String[] inputArgs)
    {
        this.byte_code = inputArgs[0];
        this.name = inputArgs[1];
        this.offset = Integer.parseInt(inputArgs[2]);
    }

    @Override
    public String getString(){
        return byte_code + " " + name + " " + offset;
    }

    @Override
    public String getByteCode(){
        return byte_code;
    }

    @Override
    public void execute(VirtualMachine vm) {}

}

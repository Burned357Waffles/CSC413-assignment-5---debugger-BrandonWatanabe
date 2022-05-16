package interpreter.bytecode;

import interpreter.VirtualMachine;

public class FunctionCode extends ByteCode
{
    private String byte_code;
    private String name;
    private int start;
    private int end;

    public FunctionCode(){}

    @Override
    public void init(String[] inputArgs)
    {
        this.byte_code = inputArgs[0];
        this.name = inputArgs[1];
        this.start = Integer.parseInt(inputArgs[2]);
        this.end = Integer.parseInt(inputArgs[3]);
    }

    @Override
    public String getString(){
        return byte_code + " " + name + " " + start + " " + end;
    }

    @Override
    public String getByteCode(){
        return byte_code;
    }

    @Override
    public void execute(VirtualMachine vm) {}

}

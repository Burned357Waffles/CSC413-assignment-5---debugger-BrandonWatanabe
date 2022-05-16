package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode
{
    private String byte_code;
    private int argument;

    public PopCode(){}

    @Override
    public void init(String[] inputArgs)
    {
        this.byte_code = inputArgs[0];
        this.argument = Integer.parseInt(inputArgs[1]);
    }

    @Override
    public String getString(){
        return byte_code + " " + argument;
    }

    @Override
    public String getByteCode(){
        return byte_code;
    }

    @Override
    public void execute(VirtualMachine vm)
    {
        vm.popN(argument);
    }


}

package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.LineCode;
import interpreter.debugger.DebuggerVirtualMachine;

public class LineDebuggerCode extends LineCode {

    private String byte_code;
    private int argument;

    @Override
    public void init(String[] inputArgs)
    {
        this.byte_code = inputArgs[0];
        this.argument = Integer.parseInt(inputArgs[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        super.execute(vm);
        DebuggerVirtualMachine dvm = (DebuggerVirtualMachine) vm;
        dvm.setLine(argument);
    }
}

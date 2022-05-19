package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.FormalCode;
import interpreter.debugger.DebuggerVirtualMachine;

public class FormalDebuggerCode extends FormalCode {

    private String byte_code;
    private Integer argument;
    private String id = "";

    @Override
    public void init(String[] inputArgs)
    {
        this.byte_code = inputArgs[0];
        this.id = inputArgs[1];
        this.argument = Integer.parseInt(inputArgs[2]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        super.execute(vm);
        DebuggerVirtualMachine dvm = (DebuggerVirtualMachine) vm;
        dvm.enterLit(id, argument);
    }
}

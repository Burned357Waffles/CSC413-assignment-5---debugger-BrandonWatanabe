package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.LitCode;
import interpreter.debugger.DebuggerVirtualMachine;

public class LitDebuggerCode extends LitCode {

    private String byte_code;
    private Integer argument;
    private boolean hasId = false;
    private String id = "";
    private int args_count;

    @Override
    public void init(String[] inputArgs)
    {
        this.args_count = inputArgs.length;
        this.byte_code = inputArgs[0];
        this.argument = Integer.parseInt(inputArgs[1]);
        if (args_count == 3) {
            this.id = inputArgs[2];
            this.hasId = true;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        super.execute(vm);
        DebuggerVirtualMachine dvm = (DebuggerVirtualMachine) vm;
        if (hasId) dvm.enterLit(id, argument); //TODO fix argument to be offset
    }
}

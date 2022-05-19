package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.FunctionCode;
import interpreter.debugger.DebuggerVirtualMachine;

public class FunctionDebuggerCode extends FunctionCode {

    private String byte_code;
    private String name;
    private int start;
    private int end;

    @Override
    public void init(String[] inputArgs)
    {
        this.byte_code = inputArgs[0];
        this.name = inputArgs[1];
        this.start = Integer.parseInt(inputArgs[2]);
        this.end = Integer.parseInt(inputArgs[3]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        super.execute(vm);
        DebuggerVirtualMachine dvm = (DebuggerVirtualMachine) vm;
        dvm.setInfo(name, start, end);
        dvm.storeCurrentPC();
        dvm.push(0);
        dvm.newFrameAt(0);
    }
}

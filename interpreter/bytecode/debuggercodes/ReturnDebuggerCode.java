package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.ReturnCode;
import interpreter.debugger.DebuggerVirtualMachine;

public class ReturnDebuggerCode extends ReturnCode {

    @Override
    public void execute(VirtualMachine vm) {
        super.execute(vm);
        DebuggerVirtualMachine dvm = (DebuggerVirtualMachine) vm;
        dvm.returnCode();
    }
}

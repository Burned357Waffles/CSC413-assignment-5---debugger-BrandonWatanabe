package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;
import interpreter.bytecode.LabelCode;
import interpreter.debugger.DebuggerVirtualMachine;

public class LabelDebuggerCode extends LabelCode {

    @Override
    public void execute(VirtualMachine vm) {
        super.execute(vm);
        DebuggerVirtualMachine dvm = (DebuggerVirtualMachine) vm;
        dvm.beginScope();
    }
}

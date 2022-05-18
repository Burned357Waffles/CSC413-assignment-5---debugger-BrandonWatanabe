package interpreter.debugger.ui;

import interpreter.debugger.DebuggerVirtualMachine;

public class ContinueCommand extends DebuggerCommand{
    private DebuggerShell shell;
    private DebuggerVirtualMachine dvm;

    public ContinueCommand(DebuggerShell shell){
        this.shell = shell;
        this.dvm = shell.getDvm();
    }

    @Override
    public void execute() {
        for (int key : shell.getLineMap().keySet()) {
            boolean isBreakpoint = shell.getLineMap().get(key).get(1).equals("true");
            if (!isBreakpoint) shell.advanceCurrentLine();
            else break;
        }
    }
}

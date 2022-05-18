package interpreter.debugger.ui;

import interpreter.debugger.DebuggerVirtualMachine;

public class ContinueCommand extends DebuggerCommand{
    private DebuggerShell shell;
    private DebuggerVirtualMachine dvm;
    private int currentLineNumber;

    public ContinueCommand(DebuggerShell shell){
        this.shell = shell;
        this.dvm = shell.getDvm();
        this.currentLineNumber = shell.getCurrentLine() + 1;
    }

    @Override
    public void execute() {
        for (int key = currentLineNumber; key <= shell.getLineMap().keySet().size(); key++) {
            if (shell.getLineMap().get(key).isBreakpoint()) {
                shell.advanceCurrentLine();
                break;
            }
            else {
                shell.advanceCurrentLine();
                currentLineNumber++;
            }
        }
    }
}

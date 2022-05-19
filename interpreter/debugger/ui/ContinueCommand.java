package interpreter.debugger.ui;

import interpreter.debugger.DebuggerVirtualMachine;

public class ContinueCommand extends DebuggerCommand{
    private DebuggerShell shell;
    private DebuggerVirtualMachine dvm;
    private int currentLineNumber;

    public ContinueCommand(DebuggerShell shell){
        this.shell = shell;
        this.dvm = shell.getDvm();
        this.currentLineNumber = shell.getCurrentLine();
    }

    @Override
    public void execute() {
        dvm.executeProgram();
        for (int key = currentLineNumber; key < shell.getLineMap().keySet().size(); key++) {
            if (shell.getLineMap().get(key).isBreakpoint()) {
                break;
            }
            else {
                shell.advanceCurrentLine();
                dvm.executeProgram();
                currentLineNumber++;
            }
        }
    }
}

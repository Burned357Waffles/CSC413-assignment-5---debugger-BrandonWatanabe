package interpreter.debugger.ui;

import interpreter.debugger.DebuggerVirtualMachine;

public class StepCommand extends DebuggerCommand{
    private DebuggerShell shell;
    private DebuggerVirtualMachine dvm;

    public StepCommand(DebuggerShell shell)
    {
        this.shell = shell;
        this.dvm = shell.getDvm();
    }

    @Override
    public void execute() {
        shell.advanceCurrentLine();
    }
}

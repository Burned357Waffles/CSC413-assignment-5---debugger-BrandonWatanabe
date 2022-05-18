package interpreter.debugger.ui;

import interpreter.debugger.DebuggerVirtualMachine;

public class LocalsCommand extends DebuggerCommand{
    private DebuggerShell shell;
    private DebuggerVirtualMachine dvm;

    public LocalsCommand(DebuggerShell shell){
        this.shell = shell;
        this.dvm = shell.getDvm();
    }

    @Override
    public void execute() {

    }
}

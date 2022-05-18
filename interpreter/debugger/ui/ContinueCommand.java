package interpreter.debugger.ui;

public class ContinueCommand extends DebuggerCommand{
    private DebuggerShell shell;

    public ContinueCommand(DebuggerShell shell){
        this.shell = shell;
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

package interpreter.debugger.ui;

public class ListCommand extends DebuggerCommand{
    private DebuggerShell shell;

    public ListCommand(DebuggerShell shell){
        this.shell = shell;
    }
    @Override
    public void execute() {
        for (int key : shell.getLineMap().keySet()) {
            if (shell.getLineMap().get(key).isBreakpoint())
                System.out.println("  * " + key + ": " + shell.getLineMap().get(key).getSourceLine());
        }
    }
}

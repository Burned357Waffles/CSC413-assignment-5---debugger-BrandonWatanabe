package interpreter.debugger.ui;

public class ListCommand extends DebuggerCommand{
    private DebuggerShell shell;

    public ListCommand(DebuggerShell shell){
        this.shell = shell;
    }
    @Override
    public void execute() {
        for (int key : shell.getLineMap().keySet()) {
            boolean isBreakpoint = shell.getLineMap().get(key).get(1).equals("true");
            if (isBreakpoint) System.out.println("    " + key + ": " + shell.getLineMap().get(key).get(0));
        }
    }
}

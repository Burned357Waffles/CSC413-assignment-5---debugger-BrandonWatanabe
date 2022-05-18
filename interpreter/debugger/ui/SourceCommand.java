package interpreter.debugger.ui;

public class SourceCommand extends DebuggerCommand{
    private DebuggerShell shell;
    private int lineNumber;

    public SourceCommand(DebuggerShell shell) {
        this.shell = shell;
        this.lineNumber = shell.getCurrentLine();
    }
    @Override
    public void execute() {
        for (int key : shell.getLineMap().keySet()){
            boolean isBreakpoint = shell.getLineMap().get(key).isBreakpoint();
            if (key == lineNumber) System.out.print("  ->");
            else System.out.print("    ");
            if (isBreakpoint) System.out.print("  * ");
            else System.out.print("    ");
            System.out.println(key + ": " + shell.getLineMap().get(key).getSourceLine());
        }
    }
}

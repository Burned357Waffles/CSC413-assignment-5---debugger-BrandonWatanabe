package interpreter.debugger.ui;

public class StepCommand extends DebuggerCommand{
    private DebuggerShell shell;

    public StepCommand(DebuggerShell shell){
        this.shell = shell;
    }

    @Override
    public void execute() {
        shell.advanceCurrentLine();
    }
}

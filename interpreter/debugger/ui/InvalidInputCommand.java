package interpreter.debugger.ui;

public class InvalidInputCommand extends DebuggerCommand{
    @Override
    public void execute() {
        System.out.println("Error: Invalid input, please try again.");
    }
}

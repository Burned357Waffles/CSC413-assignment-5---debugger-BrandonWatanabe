package interpreter.debugger.ui;

public class HelpCommand extends DebuggerCommand{

    @Override
    public void execute() {
        System.out.println("set\n" +
                "list\n" +
                "locals\n" +
                "source\n" +
                "step\n" +
                "continue\n" +
                "exit");
    }
}

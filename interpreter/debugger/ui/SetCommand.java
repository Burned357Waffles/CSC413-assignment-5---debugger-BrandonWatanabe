package interpreter.debugger.ui;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class SetCommand extends DebuggerCommand{
    private DebuggerShell shell;

    public SetCommand(DebuggerShell shell){
        this.shell = shell;
    }

    @Override
    public void execute() {
        HashMap<Integer, Vector<String>> lineMap = shell.getLineMap();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter line number: ");
        lineMap.get(input.nextInt()).set(1, "true");
    }
}

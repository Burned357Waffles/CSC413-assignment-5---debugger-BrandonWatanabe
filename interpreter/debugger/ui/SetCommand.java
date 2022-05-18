package interpreter.debugger.ui;

import interpreter.debugger.DebuggerVirtualMachine;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class SetCommand extends DebuggerCommand{
    private DebuggerShell shell;
    private DebuggerVirtualMachine dvm;

    public SetCommand(DebuggerShell shell)
    {
        this.shell = shell;
        this.dvm = shell.getDvm();
    }

    @Override
    public void execute() {
        HashMap<Integer, Vector<String>> lineMap = shell.getLineMap();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter line number: ");
        lineMap.get(input.nextInt()).set(1, "true");
    }
}

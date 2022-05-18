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
        HashMap<Integer, Entry> lineMap = shell.getLineMap();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter line number: ");
        if (!input.hasNextInt()) System.out.println("Invalid input");
        else lineMap.get(input.nextInt()).setBreakpoint(true);
    }
}

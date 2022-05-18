package interpreter.debugger;

import interpreter.ByteCodeLoader;
import interpreter.Interpreter;
import interpreter.Program;
import interpreter.debugger.ui.DebuggerCommand;
import interpreter.debugger.ui.DebuggerShell;
import interpreter.debugger.ui.ExitCommand;


public class Debugger extends Interpreter {
  protected ByteCodeLoader debuggerByteCodeLoader;
  String baseFileName;
  private String sourceFileName;
  private DebuggerShell shell;

  public Debugger(String baseFileName) {
    super(baseFileName);
    this.baseFileName = baseFileName; // Ex: factorial.x.cod
    sourceFileName = baseFileName.substring(0, baseFileName.length() - 4); // Ex: factorial.x
  }

  @Override
  public void run() {
    Program program = byteCodeLoader.loadDebuggerCodes();
    DebuggerVirtualMachine vm = new DebuggerVirtualMachine(program, this);
    shell = new DebuggerShell(vm, sourceFileName);
    while (true) {
      DebuggerCommand command = shell.prompt();
      if (command instanceof ExitCommand){
        break;
      }
      command.execute();
    }
  }
}
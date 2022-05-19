package interpreter.debugger;

import interpreter.ByteCodeLoader;
import interpreter.Interpreter;
import interpreter.Program;
import interpreter.debugger.ui.DebuggerCommand;
import interpreter.debugger.ui.DebuggerShell;
import interpreter.debugger.ui.ExitCommand;


public class Debugger extends Interpreter {
  String byteCodeFileName;
  private String sourceFileName;
  private DebuggerShell shell;

  public Debugger(String baseFileName) {
    super(baseFileName + ".x.cod");
    this.byteCodeFileName = baseFileName + ".x.cod";
    this.sourceFileName = baseFileName + ".x";
    DebuggerCodeTable.init();
  }

  @Override
  public void run() {
    Program debugProgram = byteCodeLoader.loadDebuggerCodes();
    DebuggerVirtualMachine vm = new DebuggerVirtualMachine(debugProgram, this);
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
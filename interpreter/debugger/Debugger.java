package interpreter.debugger;

import interpreter.ByteCodeLoader;
import interpreter.Interpreter;
import interpreter.Program;
import interpreter.debugger.ui.DebuggerShell;


public class Debugger extends Interpreter {
  protected ByteCodeLoader debuggerByteCodeLoader;
  String baseFileName;
  private String sourceFileName;
  private DebuggerShell shell;

  public Debugger(String baseFileName) {
    super(baseFileName);
    this.baseFileName = baseFileName;
    sourceFileName = baseFileName.substring(0, baseFileName.length() - 4);
  }

  @Override
  public void run() {
    shell = new DebuggerShell(this, sourceFileName);
    Program program = byteCodeLoader.loadCodes(true);
    DebuggerVirtualMachine vm = new DebuggerVirtualMachine(program, this);

    shell.prompt().execute();
  }
}
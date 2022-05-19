package interpreter.debugger;

import interpreter.Program;
import interpreter.RunTimeStack;
import interpreter.VirtualMachine;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;
import java.util.Stack;

public class DebuggerVirtualMachine extends VirtualMachine {
  private Debugger debugger;
  private Program debugProgram;
  private Stack<FunctionEnvironmentRecord> environmentStack;
  private int pc;
  private boolean isRunning;
  private ArrayList<Integer> breakpointList = new ArrayList<>();
  int currentLineNumber = -1;

  public DebuggerVirtualMachine(Program debugProgram, Debugger debugger) {
    super(debugProgram);
    this.debugProgram = debugProgram;
    this.debugger = debugger;
    pc = 0;
    environmentStack = new Stack<>();
    environmentStack.push(new FunctionEnvironmentRecord());
    isRunning = true;
  }

  @Override
  public void executeProgram(){
    while (isRunning) {
      for (Integer i : breakpointList) {
        if (currentLineNumber == i) {
          isRunning = false;
          break;
        }
      }
        ByteCode code = debugProgram.getCode(pc);
          code.execute(this);
        pc++;
        if (pc == debugProgram.byteCodeList.size()) isRunning = false;
    }
  }

  public void setBreakpoint(int lineNumber){ breakpointList.add(lineNumber); }

  public void stepLine(){
    int executeTo = currentLineNumber + 1;
    if (executeTo == 0) executeTo = 1;
    while (currentLineNumber < executeTo) {
        ByteCode code = debugProgram.getCode(pc);
        code.execute(this);
        pc++;
        if (pc == debugProgram.byteCodeList.size()) break;
    }
  }

  public void printEnvironmentStack(){
    for (int i = 1; i < environmentStack.size(); i++){
      environmentStack.get(i).print();
    }
    System.out.println();
  }

  public void beginScope(){
    environmentStack.push(new FunctionEnvironmentRecord());
    environmentStack.peek().beginScope();
  }

  public void setLine(int lineNumber){
    currentLineNumber = lineNumber;
    environmentStack.peek().setFuncitonLineNumber(lineNumber);
    printEnvironmentStack();
  }

  public void setInfo(String name, int start, int end) {
    environmentStack.peek().setFunctionInfo(name, start, end);
    printEnvironmentStack();
  }

  public void enterLit(String symbol, int value){
    environmentStack.peek().enter(symbol, value);
    printEnvironmentStack();
  }

  public void returnCode(){
    printEnvironmentStack();
    environmentStack.pop();
  }


}
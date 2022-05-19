package interpreter.debugger.ui;

import interpreter.debugger.Debugger;
import interpreter.debugger.DebuggerVirtualMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Vector;

public class DebuggerShell {
  private DebuggerVirtualMachine dvm;
  private HashMap<Integer, Entry> lineMap = new HashMap<>();
  private int currentLine = 1;

  public DebuggerShell(DebuggerVirtualMachine dvm, String sourceFileName) {
    this.dvm = dvm;

    try
    {
      File codeFile = new File(sourceFileName);
      Scanner inputFile =  new Scanner(codeFile);
      int lineCounter = 1;
      while (inputFile.hasNext())
      {
        String nextLine = inputFile.nextLine();
        Entry entry = new Entry(lineCounter, nextLine, false);
        lineMap.put(lineCounter, entry);
        lineCounter++;
      }
      inputFile.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File " + sourceFileName + " not found." );
    }

    new SourceCommand(this).execute();
  }

  public HashMap<Integer, Entry> getLineMap() { return lineMap;}

  public void advanceCurrentLine(){
    currentLine++;
  }

  public int getCurrentLine() {
    return currentLine;
  }

  public DebuggerVirtualMachine getDvm(){
    return dvm;
  }

  public DebuggerCommand prompt() {
    Scanner inputScanner = new Scanner(System.in);
    System.out.println("Type ? for help");
    String userInput = inputScanner.nextLine();
    if (userInput.equals("?")) return new HelpCommand();
    else if (userInput.equals("set")) return new SetCommand(this);
    else if (userInput.equals("list")) return new ListCommand(this);
    else if (userInput.equals("locals")) return new LocalsCommand(this);
    else if (userInput.equals("source")) return new SourceCommand(this);
    else if (userInput.equals("step")) return new StepCommand(this);
    else if (userInput.equals("continue")) return new ContinueCommand(this);
    else if (userInput.equals("exit") || userInput.equals("x")) return new ExitCommand();
    return new InvalidInputCommand();
  }
}
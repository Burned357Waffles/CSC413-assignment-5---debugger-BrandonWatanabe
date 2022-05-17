package interpreter.debugger.ui;

import interpreter.debugger.Debugger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DebuggerShell {
  public DebuggerShell(Debugger debugger, String sourceFileName) {
    try
    {
      File codeFile = new File(sourceFileName);
      Scanner inputFile =  new Scanner(codeFile);
      while (inputFile.hasNext())
      {
        String nextLine = inputFile.nextLine();
        System.out.println(nextLine);
      }
      inputFile.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File " + sourceFileName + " not found." );
    }
  }

  public DebuggerCommand prompt() {
    // Create the correct command object here, based on user interaction,
    // and return
    return null;
  }
}
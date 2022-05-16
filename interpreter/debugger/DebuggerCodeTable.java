package interpreter.debugger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import interpreter.CodeTable;

public class DebuggerCodeTable {

  private static HashMap<String, String> codeMap = new HashMap<>();
  private static String byteCodeFile = "interpreter/debugger/debuggerbytecodes.txt";

  public static void init() {
    CodeTable.init();
    codeMap = (HashMap<String, String>) CodeTable.getByteCodeMap().clone();
  }

  public static void populateMap() {
    try
    {
      File codeFile = new File(byteCodeFile);
      Scanner inputFile =  new Scanner(codeFile);
      while (inputFile.hasNext())
      {
        String nextLine = inputFile.nextLine();
        String[] readLine = nextLine.split(", ");
        codeMap.put(readLine[0], readLine[1]);
      }
      inputFile.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File " + byteCodeFile + " not found." );
    }
  }

  public static String get(String code) {
    String result = codeMap.get(code.trim().toUpperCase());

    if(result == null) {
      return CodeTable.get(code);
    } else {
      return result;
    }
  }
}
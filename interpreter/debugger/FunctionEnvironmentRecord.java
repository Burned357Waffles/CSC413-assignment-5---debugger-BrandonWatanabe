package interpreter.debugger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class FunctionEnvironmentRecord {

  public HashMap<String, Stack<Integer>> variableMap = new HashMap<>();
  public Stack<String> variableOrder = new Stack<>();
  public ArrayList<String> recordList = new ArrayList<>();

  public FunctionEnvironmentRecord(){}

  public void print(){
    System.out.println("< " + recordList.get(0)
                      + ", " + recordList.get(1)
                      + ", " + recordList.get(2)
                      + ", " + recordList.get(3)
                      + ", " + recordList.get(4) + " >" );
  }

  public void beginScope() {;
    for(int i = 0; i < 5; i++){
      recordList.add("-");
    }
  }

  public void setFunctionInfo(String functionName, int startingLineNumber, int endingLineNumber) {
    recordList.set(0, "()");
    recordList.set(1, Integer.toString(startingLineNumber));
    recordList.set(2, Integer.toString(endingLineNumber));
    recordList.set(3, functionName);
  }

  public void setFuncitonLineNumber(int currentFuncitonLineNumber) {
    recordList.set(4, Integer.toString(currentFuncitonLineNumber));
  }

  public void enter(String symbol, int value) {
    variableOrder.push(symbol);
    if (variableMap.containsKey(symbol)){
      variableMap.get(symbol).push(value);
    }
    else {
      Stack<Integer> variableStack = new Stack<>();
      variableStack.push(value);
      variableMap.put(symbol, variableStack);
    }

    setRecordListVariables();
  }

  public void pop(int count) {
    for(int i = 0; i < count; i++) {
      String varToPop = variableOrder.pop();
      variableMap.get(varToPop).pop();
      if (variableMap.get(varToPop).empty()) variableMap.remove(varToPop);
    }
    setRecordListVariables();
  }

  public void setRecordListVariables() {
    recordList.set(0, "(");
    String output = recordList.get(0);
    for (String key : variableMap.keySet()){
      output += " <" + key + "," + variableMap.get(key).peek() + "> ";
    }
    output += ")";
    recordList.set(0, output);
  }

  /**
   * Utility method to test your implementation. The output should be:
   * <(<VARIABLE, INDEX>), STARTING#, ENDING#, NAME, CURRENT#>
   * (<>, -, -, -, -)
   * (<>, g, 1, 20, -)
   * (<>, g, 1, 20, 5)
   * (<a/4>, g, 1, 20, 5)
   * (<b/2, a/4>, g, 1, 20, 5)
   * (<b/2, a/4, c/7>, g, 1, 20, 5)
   * (<b/2, a/1, c/7>, g, 1, 20, 5)
   * (<b/2, a/4>, g, 1, 20, 5)
   * (<a/4>, g, 1, 20, 5)
   */
  public static void main(String[] args) {
    FunctionEnvironmentRecord record = new FunctionEnvironmentRecord();

    record.beginScope();
    record.print();

    record.setFunctionInfo("g", 1, 20);
    record.print();

    record.setFuncitonLineNumber(5);
    record.print();

    record.enter("a", 4);
    record.print();

    record.enter("b", 2);
    record.print();

    record.enter("c", 7);
    record.print();

    record.enter("a", 1);
    record.print();

    record.pop(2);
    record.print();

    record.pop(1);
    record.print();

    record.pop(1);
    record.print();
  }
}
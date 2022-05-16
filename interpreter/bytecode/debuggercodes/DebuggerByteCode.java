package interpreter.bytecode.debuggercodes;

import interpreter.VirtualMachine;

public abstract class DebuggerByteCode {
    public boolean hasId = false;
    public String id = "";

    public DebuggerByteCode(){}
    public void setTarget(int target){}
    public String getArgument(){return "";}
    public boolean isId(){return false;}
    public String getId() {return id;}
    public String getNumber() {return "";}
    public abstract void init(String[] inputArgs);
    public abstract String getString();
    public abstract String getByteCode();
    public abstract void execute(VirtualMachine vm);
}

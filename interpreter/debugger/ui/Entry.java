package interpreter.debugger.ui;

public class Entry {
    private int lineNumber;
    private String sourceLine;
    private boolean isBreakpoint;

    public Entry(int lineNumber, String sourceLine, boolean isBreakpoint){
        this.lineNumber = lineNumber;
        this.sourceLine = sourceLine;
        this.isBreakpoint = isBreakpoint;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getSourceLine() {
        return sourceLine;
    }

    public boolean isBreakpoint() {
        return isBreakpoint;
    }

    public void setBreakpoint(boolean breakpoint) {
        isBreakpoint = breakpoint;
    }
}

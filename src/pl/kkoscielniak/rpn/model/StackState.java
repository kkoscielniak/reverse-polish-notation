package pl.kkoscielniak.rpn.model;

/**
 * This class is used to send current stack state to the controller.
 * @author krystian
 */
public class StackState {
    
    /**
     * Holds stack for current stack state
     */
    private String stack;
    /**
     * Holds operator for current stack state
     */
    private String operator;
    
    /**
     * Saves current stack state as an object consisting of two strings
     * @param stack current elements on stack
     * @param operator current operator
     */
    public StackState(String stack, String operator) {
        this.stack = stack;
        this.operator = operator;
    }
    
    /**
     * Returns current stack elements as string
     * @return stack as string
     */
    public String getStack() {
        return this.stack;
    }
    
    /**
     * Returns current operator
     * @return operator
     */
    public String getOperator() {
        return this.operator;
    }
}

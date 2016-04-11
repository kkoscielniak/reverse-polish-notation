package pl.kkoscielniak.rpn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Responsible for maintaining the calculations of Reverse Polish Notation
 * @author krystian
 */
public class ReversePolishNotation {
    
    /**
     * The constructor takes no arguments
     */
    public ReversePolishNotation() {
        
    }
    
    /**
     * Calculates and saves the whole process of calculation of the Reverse
     * Polish notation.
     * @param arguments equation saved as an array
     * @return stackStates as a list 
     */
    public List<StackState> calculateRPN(String[] arguments) {
        
        String operators = "+-*/";
 
        Stack<String> stack = new Stack<>();
        List<StackState> stackStates = new ArrayList<>();
 
        for(String arg : arguments){
            if (!operators.contains(arg)) {
                stack.push(arg);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(arg);
                
                switch (index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
            
            StackState ss = new StackState(stack.toString(), arg);
            stackStates.add(ss); 
        }
        return stackStates;
    };
}

package pl.kkoscielniak.rpn.controller;

import java.util.EmptyStackException;
import java.util.List;
import pl.kkoscielniak.rpn.model.ReversePolishNotation;
import pl.kkoscielniak.rpn.model.StackState;

/**
 * Responsible for interacting with the model 
 * and changing the presentation layer of the view.
 * @author krystian
 */
public class Controller {

    /**
     * Method responsible for the work flow and catching existing exceptions.
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        ReversePolishNotation rpn = new ReversePolishNotation();
        
        try {
            List<StackState> evaluatedStackStates = rpn.CalculateRPN(args);
            
            for (StackState evaluatedStackState : evaluatedStackStates) {
                System.out.println(evaluatedStackState.getStack());
            }
            
        } catch (EmptyStackException e) {
            System.out.println("The stack is empty!");
        }
    }
}

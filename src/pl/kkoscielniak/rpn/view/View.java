package pl.kkoscielniak.rpn.view;

import java.util.List;
import java.util.Scanner;
import pl.kkoscielniak.rpn.model.StackState;

/**
 * Responsible for maintaining the presentation layer - the view. 
 * @author krystian
 */
public class View {
    /**
     * Represents instance of Scanner object, which is responsible for 
     * collecting information from user.
     */
    private final Scanner scanner = new Scanner(System.in);
    
    /**
     * The contructor takes no arguments.
     */
    public View() {
        
    }
    
    /**
     * Prompts for equation if the user didn't pass it as an arguments.
     * @return input written by the user
     */
    public String[] getTheEquation() {
        System.out.print("Put the equation here: ");
        String scannedEquation = scanner.nextLine();
        
        return scannedEquation.split(" ");
    }
    
    /**
     * Prints the given message
     * @param msg message to print
     */
    public void printMessage(String msg) {
        System.out.print(msg);
    }
    
    /**
     * Prints the table of steps to calculate the result.
     * @param stackStates list of saved stack states to be shown 
     */
    public void printTable(List<StackState> stackStates) {
        final String operators = "+-*/";
        final String leftAlignFormat = "| %-4s | %-30s | %-4s |%n";

        System.out.format("+------+--------------------------------+------+%n");
        System.out.format("+ Step | Current stack                  | Op   |%n");
        System.out.format("+------+--------------------------------+------+%n");

        int i = 1;        
        for (StackState stackState : stackStates) {
            
            if (!operators.contains(stackState.getOperator())) {
                System.out.format(leftAlignFormat, 
                    i,
                    stackState.getStack(), 
                    ""
                );
            } else {
                System.out.format(leftAlignFormat, 
                    i,
                    stackState.getStack(), 
                    stackState.getOperator()
                );
            }
            
            i++;
        }
        System.out.format("+------+--------------------------------+------+%n");
    }
}

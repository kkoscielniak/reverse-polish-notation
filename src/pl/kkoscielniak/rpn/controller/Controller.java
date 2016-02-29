/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            
            for(int i = 0; i < evaluatedStackStates.size(); i++) {
                System.out.println(evaluatedStackStates.get(i).getStack());
            }
            
        } catch (EmptyStackException e) {
            System.out.println("The stack is empty!");
        }
    }
}

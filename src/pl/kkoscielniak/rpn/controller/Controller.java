/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kkoscielniak.rpn.controller;

import java.util.EmptyStackException;
import pl.kkoscielniak.rpn.model.ReversePolishNotation;

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
            System.out.println(rpn.CalculateRPN(args));
            
        } catch (EmptyStackException e) {
            System.out.println("The stack is empty!");
        }
        
        
    }
}

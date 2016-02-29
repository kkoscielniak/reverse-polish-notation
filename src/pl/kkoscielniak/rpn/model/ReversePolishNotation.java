/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kkoscielniak.rpn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Responsible for maintaining the calculations of Reverse Polish Notation
 * @author krystian
 */
public class ReversePolishNotation {
    
    public ReversePolishNotation() {
        
    }
    
    public List<StackState> CalculateRPN(String[] arguments) {
        
        int calculatedValue = 0;
        
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

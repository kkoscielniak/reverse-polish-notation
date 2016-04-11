package pl.kkoscielniak.rpn.model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Collects tests related to ReversePolishNotation.class
 * @author krystian
 */
public class ReversePolishNotationTest {
    
    ReversePolishNotation rpn = new ReversePolishNotation();
    
    public ReversePolishNotationTest() {
    }    
    
    /**
     * allows to expect an exception
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();
        
    /**
     * Tests if program calculates RPN correctly
     */
    @Test
    public void shouldReturnProperValueAfterCalculation() {
        String[] input = { "2", "3", "+", "5", "*" };
        List<StackState> expectedStackState;
        expectedStackState = new ArrayList<>();
        List<StackState> resultStackState;
        resultStackState = rpn.CalculateRPN(input);
        
        // create examplary StackStates List
        StackState s;
        s = new StackState("[2]", "2");
        expectedStackState.add(s);
        s = new StackState("[2, 3]", "3");
        expectedStackState.add(s);
        s = new StackState("[5]", "+");
        expectedStackState.add(s);
        s = new StackState("[5, 5]", "5");
        expectedStackState.add(s);
        s = new StackState("[25]", "*");
        expectedStackState.add(s);
       
        // serialize both resulting and examplatry StackState Lists 
        // to comparable strings
        String expectedResult = new String();
        String result = new String();

        for (StackState stackState : expectedStackState) {
            expectedResult += stackState.getStack();
            expectedResult += stackState.getOperator();
        }
        
        for (StackState stackState : resultStackState) {
            result += stackState.getStack();
            result += stackState.getOperator();
        }
        
        assertEquals(expectedResult, result);
    }
    
    /**
     * Tests whether the exception is thrown when the input is empty
     */
    @Test 
    public void shouldThrowAnException() throws EmptyStackException {
        String[] input = {};
        
        // this should throw an exception, since input is empty
        List<StackState> result = rpn.CalculateRPN(input);
    }
    
    /**
     * Boundary test: tests whether the input is correct (no the same signs alongside)
     */
   
    @Test 
    public void shouldntHaveTwoSignsAlongside() throws EmptyStackException {
        String[] input = { "2", "3", "+", "+", "6" };
        
        exception.expect(EmptyStackException.class);
        List<StackState> result = rpn.CalculateRPN(input);
    }
}

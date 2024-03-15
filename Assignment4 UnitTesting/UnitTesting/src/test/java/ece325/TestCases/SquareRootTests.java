package ece325.TestCases;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ece325.*;

/**
 * JUnit test class for solving square roots
 */
public class SquareRootTests {

    // TODO: Assignment 4 Part 2 -- Checkpoint4

	private Calculator calc;
	private double epsilon = 0.0000001;

    @Before 
    public void setUp() throws Exception {
        calc = new Calculator();
    }

    @After 
    public void tearDown() throws Exception {
    }
    
    @Test 
    public void testRandomPostitiveSquareRoot() {
        // The result should be a complex number i.e. Double.isNaN()
    	double x = (Math.random()) * 100000000;
    	assertEquals(calc.squareRoot(x*x), Double.valueOf(x), epsilon);
        
    }

        

    @Test 
    public void testRandomNegitiveSquareRoot() {
        // The result should be a complex number i.e. Double.isNaN()
    	double x = -(Math.random()) * 100000000;
    	assertTrue(Double.isNaN(calc.squareRoot(x)));
        
    }

    @Test 
    public void testSquareRootofZero() {
        // You cannot use the Math.sqrt() function in the test!
    	double x = 0.0;
    	assertEquals(calc.squareRoot(x), Double.valueOf(0));
        
    }

    @Test 
    public void testSquareRootofOne() {
        // You cannot use the Math.sqrt() function in the test!
    	double x = 1.0;
    	assertEquals(calc.squareRoot(x), Double.valueOf(1));
        
    }

}

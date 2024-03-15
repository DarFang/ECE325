import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Assignment 5: Interfaces <br />
 * Part 1: The {@code CoffeeTest} class
 */

    public class CoffeeTest {
    	List<Coffee> coffees = new ArrayList<Coffee>();
    	@Before 
    	public void setUp() throws Exception{
    		
    	}
    	@After 
        public void tearDown() throws Exception {
        }
    	
    	@Test
    	public void sortCoffee() {
    		coffees.add(new Coffee(10));
            coffees.add(new Coffee(2));
            coffees.add(new Coffee(10));
            coffees.add(new Coffee(20));
            coffees.add(new Coffee(5));
            Collections.sort(coffees);
            for (int i = 1; i<coffees.size(); i++) {
            	assertTrue((coffees.get(i).compareTo(coffees.get(i-1))>=0));
            }
    	}
        


    }


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
/**
 * Assignment 5: Interfaces <br />
 * Part 3: The {@code PersonTest} class
 */
public class PersonTest {


        Set<Person> persons = new TreeSet<Person>(new PersonComparator());
        @Before 
    	public void setUp() throws Exception{
    		
    	}
    	@After 
        public void tearDown() throws Exception {
        }
    	
    	@Test
        public void reeee() {
        persons.add(new Person(32));
        persons.add(new Person(17));
        persons.add(new Person(13));
        persons.add(new Person(35));
        persons.add(new Person(27));

        Iterator<Person> iter = persons.iterator();
        Person i = iter.next();
        while (iter.hasNext()) {
        	Person j = iter.next();
            assertTrue((i.getAge()-j.getAge()) <= 0);
            i = j;
        }
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Animal} interface
 */
import java.util.HashMap;
interface Animal {
    /**
     * An animal speaks
     * @return              {@code String} animal speaks
     */
    public String speak ();
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Lion} class
 */
class Lion implements Animal {
    /**
     * The lion speaks
     * @return              {@code String} lion speaks
     */
    public String speak() {
        return "ROAR";
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Mouse} class
 */
class Mouse implements Animal {
    /**
     * The mouse speaks
     * @return              {@code String} mouse speaks
    */
    public String speak() {
        return "SQUEAK";
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code Bison} class
 */
class Bison implements Animal {
    /**
     * The bison speaks
     * @return              {@code String} bison speaks
     */
    public String speak() {
        return "BELLOW";
    }
}

/***
 * Add the Dog class 
 * @author DFang
 *
 */
class Dog implements Animal{
	@Override
	public String speak() {
		return "woof";
	}
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code AnimalType} class
 */
class AnimalType {
    /**
     * Create and return an animal
     * @param criteria      {@code String} how is the animal like
     * @return              {@code Animal} the animal
     */
	// This Hash map has the string criteria and the class
	public static HashMap<String, Class<? extends Animal>> animalTypes = new HashMap<>();
	

    public static Animal getAnimal(String criteria)  {
        // TODO: Lab 6 Part 2-1 -- Refactor this method
    	try {
    		// get criteria gets the class, then new Instances get the new object of that instance
    		return AnimalType.animalTypes.get(criteria).newInstance();
    	}
    	catch(Exception e) {
    		return null;
    	}
    }
}

/**
 * Lab 6: Anonymous Inner Classes and Reflection <br />
 * The {@code JavaDPExample} class
 */
public class JavaDPExample {
    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
    	// Add these to the HashMap inside the AnimalType
    	AnimalType.animalTypes.put("small", Mouse.class);
    	AnimalType.animalTypes.put("big", Bison.class);
    	AnimalType.animalTypes.put("lazy", Lion.class);
    	
    	
        Animal small = AnimalType.getAnimal("small");
        System.out.println(small.getClass().getName() + " speaks: " + small.speak());
        Animal big = AnimalType.getAnimal("big");
        System.out.println(big.getClass().getName() + " speaks: " + big.speak());
        Animal lazy = AnimalType.getAnimal("lazy");
        System.out.println(lazy.getClass().getName() + " speaks: " + lazy.speak());

        // TODO: Lab 6 Part 2-2 -- add an animal "Dog" here: criteria="loyal"; speak="woof"
        
        AnimalType.animalTypes.put("loyal", Dog.class);
        Animal loyal = AnimalType.getAnimal("loyal");
        System.out.println(loyal.getClass().getName() + " speaks: " + loyal.speak());

        // TODO: Lab 6 Part 2-3 -- remove the "small" animal here: Mouse
        AnimalType.animalTypes.remove("small");
        try {
            small = AnimalType.getAnimal("small");
            System.out.println(small.getClass().getName() + " speaks: " + small.speak());
        } catch (Exception e) {
            System.out.println("Unknwon animal...");
        }
    }
}

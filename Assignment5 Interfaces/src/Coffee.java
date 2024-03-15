/**
 * Assignment 5: Interfaces <br />
 * Part 1: The {@code Coffee} class
 */
public class Coffee implements Comparable<Coffee> {
    private int strength;       // The strength of the coffee
    // TODO: Assignment 5 Part 1 -- complete this class
    Coffee(int strength){
    	this.strength = strength;
    }
	@Override
	public int compareTo(Coffee c) {
		
		return strength - c.strength;
	}
}

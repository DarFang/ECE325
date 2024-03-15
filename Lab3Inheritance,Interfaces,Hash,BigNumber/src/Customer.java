/**
 * The {@code Customer} class
 */
public class Customer extends Person  implements Printable{

	private double projPrice;
	/**
	 * Constructor
	 * @param String name name of person
	 * @param double projPrice project price
	 **/
	Customer(String name, double projPrice){
		super(name);
		this.projPrice = projPrice;
	}
	/**
	 * Gets the project price
	 * @return {@code double} projPrice The project price
	 */
	public double getProjPrice() {
		return projPrice;
	}
	@Override
	/**
	 * 
	 */
	public String PrintInfo() {
		return "Name: " + getName() + " Project price: " + projPrice;
	}
}

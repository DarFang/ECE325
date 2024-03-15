import java.util.Objects;
/**
 * The {@code Person} class
 */
public class Person{
	private String name;
	/**
	 * Constructor
	 * @param String name name of person
	 */
	Person(String name){
		this.name = name;
	}
	/**
	 * Gets the name of the person
	 * @return {@code String} name name of the person
	 */
	public String getName(){
		return name;
	}
	@Override
	/**
	 * Hashcode return
	 * @return int hash value of object
	 */
	public int hashCode() {
		return Objects.hash(getName());
	}
	/**
	 * @param obj object of input
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if(!(obj instanceof SwEngineer)) {
			return false;
		}
		SwEngineer person = (SwEngineer) obj;
		return getName().equals(person.getName());
		
	}
}

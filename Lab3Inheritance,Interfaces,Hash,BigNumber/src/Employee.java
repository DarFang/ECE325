import java.util.Objects;
/**
 * The {@code Employee} class
 */
public class Employee extends Person{

	private double baseSalary;
	/**
	 * Constructor
	 * @param String name name of person
	 * @param double baseSalary base salary of employee
	 */
	Employee(String name, double baseSalary){
		super(name);
		this.baseSalary = baseSalary;
	}
	/**
	 * Get the base salary of the employee
	 * @return {@code double} baseSalary
	 */
	public double getBaseSalary() {
		return baseSalary;
	}
	
	@Override
	/**
	 * 
	 */
	public int hashCode() {
		return Objects.hash(getName(), getBaseSalary());
	}
	@Override
	/**
	 * 
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if(!(obj instanceof SwEngineer)) {
			return false;
		}
		SwEngineer employee = (SwEngineer) obj;
		return getName().equals(employee.getName())
				&& (getBaseSalary() == employee.getBaseSalary());
		
	}
}
import java.util.Objects;
/**
 * The {@code SwEngineer} class
 */
public class SwEngineer extends Employee{
	private String projName;
	/**
	 * Constructor
	 * @param String name name of person
	 * @param double baseSalary base salary of employee
	 * @param String projName project name 
	 */
	SwEngineer(String name, double baseSalary, String projName){
		super(name, baseSalary);
		this.projName = projName;
	}
	/**
	 * gets the project name
	 * @return String project name
	 */
	public String getProjName() {
		return projName;
	}
	@Override
	/**
	 * 
	 */
	public int hashCode() {
		return Objects.hash(getProjName(), getName(), getBaseSalary());
	}
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if(!(obj instanceof SwEngineer)) {
			return false;
		}
		SwEngineer engineer = (SwEngineer) obj;
		return getProjName().equals(engineer.getProjName()) && getName().equals(engineer.getName())
				&& (getBaseSalary() == engineer.getBaseSalary());
		
	}
}
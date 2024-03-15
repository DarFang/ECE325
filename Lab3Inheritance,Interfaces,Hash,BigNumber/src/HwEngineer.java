/**
 * The {@code HwEngineer} class
 */
public class HwEngineer extends Employee implements SalaryRaisable{
	/**
	 * Constructor
	 * @param String name name of person
	 * @param double baseSalary base salary of employee
	 */
	
	HwEngineer(String name, double baseSalary){
		super(name, baseSalary);
	}
	public String getFinalSal() {
		return "Final salary for " + getName() + " is: "+(getBaseSalary()+RaiseSalary());
		}
	/**
	 * Raise Salary from base salary
	 */
	@Override
	public double RaiseSalary() {
		return getBaseSalary()*0.18;
	}
}
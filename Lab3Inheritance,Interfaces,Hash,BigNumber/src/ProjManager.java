import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
/**
 * The {@code ProjManager} class
 */
public class ProjManager extends SwEngineer implements SalaryRaisable, Printable{
	private Date projDeadline;
	/**
	 * Constructor
	 * @param String name name of person 
	 * @param double baseSalary base salary of employee
	 * @param String projName project name
	 * @param Date projDeadline project deadline
	 */
	ProjManager(String name, double baseSalary, String projName, Date projDeadline){
		super(name, baseSalary, projName);
		this.projDeadline = projDeadline;
		}
	/**
	 * get project deadline
	 * @return String project deadline date
	 */
	public String getProjDeadline() {
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(projDeadline);
		}
	/**
	 * 
	 */
	@Override
	/**
	 * 
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if(!(obj instanceof ProjManager)) {
			return false;
		}
		ProjManager manager = (ProjManager) obj;
		return getProjName().equals(manager.getProjName()) && getName().equals(manager.getName())
				&& (getBaseSalary() == manager.getBaseSalary()) && getProjDeadline().equals(manager.getProjDeadline());
		
	}
	@Override
	/**
	 * 
	 */
	public int hashCode() {
		return Objects.hash(getProjName(), getName(), getBaseSalary(), getProjDeadline());
	}
	@Override
	/**
	 * 
	 */
	public double RaiseSalary() {
		return this.getBaseSalary()*0.24 ;
	}

	/**
	 * Prints the name, project, salary, deadline
	 */
	public String PrintInfo() {
		return "Name: " + getName() + " Project: " + getProjName() + " Salary: " + (getBaseSalary()+RaiseSalary()) + " Deadline: " + getProjDeadline();
		}
	public String getFinalSal() {
		return "Final salary for " + getName() + " is: "+(getBaseSalary()+RaiseSalary());
		}
	
	}

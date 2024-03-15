import java.util.Date;

/**
 * Lab 3: Inheritance, Interfaces, Hash and Big Number <br />
 * The {@code SalaryRaisable} interface
 */
public interface SalaryRaisable {
    /**
     * @return      {@code double} The amount of salary after raising
     */
    double RaiseSalary();
   
	@SuppressWarnings("deprecation")
	public static void main (String arg[]) {
    	//Deliverable 2
    	System.out.println("Create Bob as SwEngineer with 3000 Salary doing project java");
    	SwEngineer bob = new SwEngineer("Bob", 3000, "java");
    	System.out.println("Create Zac as ProjManager with 6000 Salary doing project Z");
    	ProjManager zac = new ProjManager("Zac", 6000, "Z" , new Date(120, 11, 3));
    	System.out.println("Create Zac1 as ProjManager with 6000 Salary doing project Z");
    	ProjManager zac1 = zac;
    	System.out.println("is bob = zac?");
    	System.out.println(zac.equals(bob));
    	System.out.println("is zac = zac?");
    	System.out.println(zac.equals(zac));
    	System.out.println("is zac = zac1?");
    	System.out.println(zac.equals(zac1));
    	System.out.println("zac's hash code: " + zac.hashCode());
    	System.out.println("bob's hash code: " + bob.hashCode());
    	System.out.println("zac's hash code: " + zac1.hashCode());
    }
}

import java.util.Date;
/**
 * Lab 3: Inheritance, Interfaces, Hash and Big Number <br />
 * The {@code Printable} interface
 */
public interface Printable {
    /**
     * @return      {@code String} The printable information in the string type.
     */
    String PrintInfo();
    @SuppressWarnings("deprecation")
	public static void main (String arg[]) {
    	//Deliverable 1
    	System.out.println("Create Bob as HwEngineer with 3000 Salary");
    	HwEngineer bob = new HwEngineer("Bob", 3000);
    	System.out.println("Create Zac as ProjManager with 6000 Salary doing project Z");
    	ProjManager zac = new ProjManager("Zac", 6000, "Z" , new Date(120, 11, 3));
    	System.out.println("Create Celine as Customer with project price 10000");
    	Customer celine = new Customer("Celine", 10000);
    	System.out.println(bob.getFinalSal());
    	System.out.println(zac.getFinalSal());
    	System.out.println(zac.PrintInfo());
    	System.out.println(celine.PrintInfo());
    }


}







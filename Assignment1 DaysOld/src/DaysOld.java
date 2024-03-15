import java.util.*;
/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 * @author Darius Fang
 */
public class DaysOld {
    /**
     * Calculate how many days between today and the date
     * @param birthday      {@code String} The start date
     */
    public static void days(String birthday) {
    	
    	// Convert input into integer values from birthday
    	String[] val = birthday.split("-");
    	int B_Year = Integer.parseInt(val[0]);  // Birth year
    	int B_Month = Integer.parseInt(val[1]);  // Birth month
    	int B_Day = Integer.parseInt(val[2]);  // Birthday

    	// Get today's day of year and year from Java API
    	Calendar today = Calendar.getInstance();  // Class Calendar
    	int T_Year = today.get(Calendar.YEAR);  // Year
    	int T_Month = today.get(Calendar.MONTH); // Month
    	int T_Day = today.get(Calendar.DATE);  // Today
    	int T_DayofYear = today.get(Calendar.DAY_OF_YEAR);  // Day of the year
    	
    	// Calculate day of year for birthday 
    	int[] Month = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}; // Days after that month
    	int B_DayofYear = B_Day+ Month [B_Month-1]; // Converted to day of the year
    	
    	// Calculate if the year was a leap year
    	if(B_Year % 4 == 0 && (B_Month > 2  || (B_Month == 2 && B_Day == 29))) {
    		// If it is a leap year and it is passed Feb 29;
    		B_DayofYear++;
    	}
    	
    	//Get the value of number of days
    	int Num_Days = T_DayofYear - B_DayofYear + (T_Year-B_Year)*365; // Difference of days and years
    	Num_Days += (T_Year-B_Year)/4; //Add leap years
    	
    	//Month names
    	String[] N_Month = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    	
    	//Output
    	System.out.print("Birthday: " + B_Year + " " + N_Month[B_Month-1]+ " " + B_Day + "; ");
    	System.out.print("today: "+ T_Year + " "+ N_Month[T_Month] + " " + T_Day + " -- ");
    	
    	if(Num_Days>=0) {
    		System.out.println("You are " + Num_Days + " days old.");
    	}
    	else {
    		System.out.println("Wrong Birthday!");
    	}
    } // public static void days(String birthday)

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        days("2000-1-1");
        days("3000-1-1");  // This is a wrong birthday
        days("2000-3-26");	// Birthday
        days("2000-5-12");
    }

}

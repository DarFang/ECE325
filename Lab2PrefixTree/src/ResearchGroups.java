import java.util.Arrays;

/**
 * Lab 2: Debugging with an IDE and Prefix Tree) <br />
 * The {@code ResearchGroup} class uses a 2D array to store the names of group members
 * @author DFang 
 */
public class ResearchGroups {
    /**
     * Search a person to check whether he/she is in the groups
     * @param groups    {@code String[][]} The 2D array of groups to be searched
     * @param name      {@code String} name of the person
     */
    public static void searchMember(String[][] groups, String name) {
        // TODO: Lab 2 Part 1-1 -- search and print the results here
    	Boolean exist = false, isLeader = false;  // If it's exists, and if it's leader
    	Boolean[] ingroup = new Boolean[groups.length];
    	for(int row = 0; row < groups.length; row++) {
    		Boolean isingroup = false;  // Is it in the group?
    		for (int col = 0; col < groups[row].length; col++) {
    			if( groups[row][col].equals(name)) {
    				if (col == 0) {  // First value of the tuple
    					isLeader = true;
    				}
    				exist = true;  // Exists
    				isingroup = true;  // In this group
    			}
    			else {
    				ingroup[row] = false;  // Not in group
    			}
    		}
    		if(isingroup) {
    			ingroup[row] = true;
    		}
    	}
    	if(exist) 
    		System.out.println(name + " exists");
    		for (int i = 0; i<ingroup.length; i++) 
    			if(ingroup[i]) 
    				System.out.println(name + " is in group " + i);
    		if(isLeader) 
    			System.out.println(name + " is a group leader");
    	else 
    		System.out.println(name + " does not exist");
    	
    }
	/**
	 * Merges Left and Right array and returns the sorted array in ascending order
	 * 
	 * @param LeftArray {@code String[][]} Left portion of the array that is sorted
	 * @param RightArray  {@code String[][]} Right portion of the array that is sorted
	 * @param SortedArray  {@code String[][]} Sorted array from combining left and right array
	 * @param LeftLen  {@code int} Left length array row
	 * @param RightLen  {@code int} Right length array row
	 * @return SortedArray {@code String[][]} Returns the sorted array of the 2 arrays
	 */
    public static String[][] merge(String[][] LeftArray, String[][] RightArray, String[][] SortedArray, int LeftLen, int RightLen) {
    	// Initial increments for each array
    	int i = 0, j = 0, k = 0;
    	
    	//Sort left and right array in ascending order
    	while(i < LeftLen && j < RightLen) {
    		if(LeftArray[i].length <= RightArray[j].length) {
    			SortedArray[k++] = Arrays.copyOfRange(LeftArray[i], 0, LeftArray[i++].length);
    		}
    		else {
    			SortedArray[k++] = Arrays.copyOfRange(RightArray[j], 0, RightArray[j++].length);
    		}
    	}
    	
    	// Leftover array to be inserted (sub array is sorted already)
    	while( i < LeftLen) {
    		SortedArray[k++] = Arrays.copyOfRange(LeftArray[i], 0, LeftArray[i++].length);
    	}
    	while( j < RightLen) {
    		SortedArray[k++] = Arrays.copyOfRange(RightArray[j], 0, RightArray[j++].length);
    	}
    	
    	return SortedArray;
    }
    /**
     * The merge sort procedure
     * @param groups {@code String[][]} The integer array to be sorted
     */
    public static String[][] sort(String[][] groups){
	    int end = groups.length; // Get Length of Array
	    if (end>1) {
	    	int mid = end/2;  // Mid index
	    	// Split the array into 2
	    	String[][] LeftArray = Arrays.copyOfRange(groups,0, mid);
	    	String[][] RightArray = Arrays.copyOfRange(groups,mid, end);
	    	// Recursion
	    	sort(LeftArray);
	    	sort(RightArray);
	    	// Merge
	    	merge(LeftArray, RightArray, groups, mid, end-mid);
	    }
    	return groups;
    }
    /**
     * Sort groups by number of members <br />
     * @param groups  <code>String[][]</code> The 2D array of groups to be sorted
     */
    public static void sortGroups(String[][] groups) {
        // TODO: Lab 2 Part 1-2 -- sort and print the results here. Reuse your heapsort
    	groups = sort(groups);
        for(int i = 0; i<groups.length; i++) {
        	for(int j = 0; j<groups[i].length; j++) {
        		System.out.print(groups[i][j]+ " ");
        	}
        	System.out.println();
        }
    }
    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        String[][] groups = { {"Bob", "Carol", "Eric", "Matt"},             // 0
                              {"Jim", "Lucy", "Terry", "Brenda", "Ben"},    // 1
                              {"Susan", "Brad", "Jim"},                     // 2
                              {"Sue", "Wendy", "Sam"},                      // 3
                              {"Kate", "Jack", "James", "Sydney"},          // 4
                              {"Mohammad", "Tim", "Kian"},                  // 5
                              {"Emma", "Carol"},                            // 6
                              {"Nick", "Osama", "Harry", "Ben"},            // 7
                              {"Mary", "John", "Ricky"} };                  // 8
    	System.out.println("Part 1\n");
        ResearchGroups.searchMember(groups, "Jim");
        ResearchGroups.searchMember(groups, "Lucy");
        ResearchGroups.searchMember(groups, "John Doe");
    	System.out.println("\nPart 2\n");
        ResearchGroups.sortGroups(groups);
    }
}

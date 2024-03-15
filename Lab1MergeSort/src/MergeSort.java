/**
 * Lab 1: Java Basics, Merge Sort and Maven <br />
 * The {@code MergeSort} class
 * @author Darius Fang
 */
public class MergeSort {
	/**
	 * Merges Left and Right array and returns the sorted array in ascending order
	 * 
	 * @param LeftArray Left portion of the array that is sorted
	 * @param RightArray Right portion of the array that is sorted
	 * @param SortedArray Sorted array from combining left and right array
	 * @param LeftLen Left length array
	 * @param RightLen Right length array
	 * @return SortedArray {@code int[]} Returns the sorted array of the 2 arrays
	 */

    public static int[] merge(int[] LeftArray, int[] RightArray, int[] SortedArray, int LeftLen, int RightLen) {
    	// Initial increments for each array
    	int i = 0, j = 0, k = 0;
    	
    	//Sort left and right array in ascending order
    	while(i < LeftLen && j < RightLen) {
    		if(LeftArray[i] <= RightArray[j]) {
    			SortedArray[k++] = LeftArray[i++];
    		}
    		else {
    			SortedArray[k++] = RightArray[j++];
    		}
    	}
    	
    	// Leftover array to be inserted (sub array is sorted already)
    	while( i < LeftLen) {
    		SortedArray[k++] = LeftArray[i++];
    	}
    	while( j < RightLen) {
    		SortedArray[k++] = RightArray[j++];
    	}
    	
    	return SortedArray;
    }

    /**
     * The merge sort procedure
     * @param numbers   {@code int[]} The integer array to be sorted
     */
    public static int[] sort(int[] numbers) {
        int end = numbers.length; // Get Length of Array
        
        if (end>1) {
        	int mid = end/2;  // Mid index
        	
        	// Split the array into 2
        	int[] LeftArray = new int[mid];
        	int[] RightArray = new int[end-mid];
        	
        	// Input the values into each array
        	for (int i = 0; i < mid; i++) {
        		LeftArray[i] = numbers[i];
        	}
        	for (int j = mid; j < end; j++) {
        		RightArray[j-mid] = numbers[j];
        	}
        	
        	// Recursion
        	sort(LeftArray);
        	sort(RightArray);
        	
        	// Merge
        	merge(LeftArray, RightArray, numbers, mid, end-mid);
        }
        
	return numbers;
    }

    /**
     * Main entry: test the HeapSort
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 200);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        numbers = sort(numbers);

        for (int n: numbers)
            System.out.print(n + " ");
        System.out.println();
    }

}

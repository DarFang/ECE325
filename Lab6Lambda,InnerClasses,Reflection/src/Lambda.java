import java.util.*;
/** 
 * Class utils modifies the collection of comparator
 * 
 * @author DFang
 *
 */
class Utils{
	/**
	 * Interface twoStringPredicate compares two strings
	 */
	interface twoStringPredicate{
		boolean compare(String w1, String w2);
	}
	/**
	 * Compares if the string has a letter starting with e
	 * @param w1 first word
	 * @param w2 second word
	 * @return order of word
	 */
	public static int compare(String w1, String w2) {
		if(w1.charAt(0) == 'e') {
			return -1;
		}
		else if(w2.charAt(0) == 'e') {
			return 1;
		}
			return 0;
	}
	/**
	 * BetterString compares 2 string and returns the string that is higher
	 * @param w1 first word
	 * @param w2 second word
	 * @param comparator boolean of compare
	 * @return string of one of the 2
	 */
	public static String betterString(String w1, String w2, twoStringPredicate comparator) {
		return comparator.compare(w1, w2) ? w1:w2;
	}
}
/**
 * Main function Lambda, uses Lambda functions as parameters and outputs conditions
 * @author DFang
 *
 */
public class Lambda {
	/**
	 * Simple print the contents of the list in order
	 * @param String in is the input string related to the sort
	 * @param String[] words the array of the sorted words
	 */
	public static void printlist(String in , String [] words) {
		System.out.println(in);
		for (String n : words) {
			System.out.println(n);
		}
		System.out.println("");
	}
	/**
	 * Main has a bunch of tests and scenarios
	 * @param args
	 */
	
	public static void main(String[]args) {
		String[] words = new String[] {"calculus","engineering", "english", "physics", "linear algerbra"};
		printlist("Word List:", words);
		
		// Sort them by lengths
		Arrays.sort(words, (w1,w2) -> w1.length() - w2.length());
		printlist("Sort the list by length:", words);
		
		// Reverse Sort he lengths
		Arrays.sort(words, (w1,w2) -> w2.length() - w1.length());
		printlist("Sort the list by length decending:", words);
		
		// Reverse Sort by first char
		Arrays.sort(words, (w1,w2) -> w1.charAt(0) - w2.charAt(0));
		printlist("Sort the list by first character:", words);
		
		// Sort the list by characters start with e
		Arrays.sort(words, (w1,w2) -> {
			if(w1.charAt(0) == 'e') {
				return -1;
			}
			else if(w2.charAt(0) == 'e') {
				return 1;
			}
				return 0;
		});
		printlist("Sort the list starting with 'e':", words);
		
		// Sort the list by characters start with e static method
		Arrays.sort(words, (w1,w2) -> Utils.compare(w1,w2));
		printlist("Sort the list starting with 'e'(Static):", words);
		
		// compare 2 words
		String word1 = "java";
		String word2 = "python";
		System.out.println("List of words:\n" + word1 + "\n" +word2 + "\n");
		
		// length is greater then other length
		String longer = Utils.betterString(word1, word2, (w1,w2) -> w1.length() > w2.length());
		
		// character value is smaller than other character therefore is first
		String first = Utils.betterString(word1, word2, (w1,w2) -> w1.charAt(0) < w2.charAt(0));
		
		System.out.println(longer + " is longer");
		System.out.println(first + " is first");
	}
}

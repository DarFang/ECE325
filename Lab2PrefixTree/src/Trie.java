
/**
 * Lab 2: Debugging with an IDE and Prefix Tree)
 * @author DFang 
 */

/**
 * Trie is a prefix tree, it contains insert,  search, start with
 * 
 *
 */
class Trie {
	static final int ALPHABET_SIZE = 26;
	static class TrieNode {
	        TrieNode[] child = new TrieNode[ALPHABET_SIZE];
	        boolean isEndOfWord;
	        TrieNode(){ 
				isEndOfWord = false; 
				for (int i = 0; i < ALPHABET_SIZE; i++) 
					child[i] = null; 
			}
	    }
    /**
     * Root node of the Prefix Tree
     */	 
	static TrieNode root; 
	/**
	 * Inserts the word into the prefix tree
	 * @param word 	{@code String} inserts into the class Trie
	 */
    public static void insert(String word) {
    	// TODO: Insert a new element to the Prefix Tree
    	char [] charword = word.toCharArray();
    	TrieNode tempNode = root;
    	for (char c:charword) {
    		int index = c - 'a';
    		if(tempNode.child[index] == null) {
    			tempNode.child[index] = new TrieNode();
    		}
    		tempNode = tempNode.child[index];
    	}
    	tempNode.isEndOfWord = true;
    }
    /**
     * Compares the string in the prefix tree
     * @param word	{@code String} input string to compare into the Trie
     * @return
     */
    public static boolean search(String word) {
    	// TODO: Returns if the word is in the Prefix Tree
    	char [] charword = word.toCharArray();
    	TrieNode tempNode = root;
    	for (char c:charword) {
    		int index = c - 'a';
    		if(tempNode.child[index] == null) {
    			return false;
    		}
    		tempNode = tempNode.child[index];
    	}
    	if (tempNode != null && tempNode.isEndOfWord == false) {
    		return false;
    	}
    	return true;
    }
    /**
     * Compares the start with string to the prefix tree
     * @param prefix {@code String} input string to compare into the Trie
     * @return
     */
    public static boolean startWith(String prefix) {
    	// TODO: Returns if there is any word in the Prefix Tree that starts with the given prefix.
    	char [] charword = prefix.toCharArray();
    	TrieNode tempNode = root;
    	for (char c:charword) {
    		int index = c - 'a';
    		if(tempNode.child[index] == null) {
    			return false;
    		}
    		tempNode = tempNode.child[index];
    	}
    	return true;
    }
    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String args[]) 
	{ 
		String words[] = {"ece", "lab", "java", "jar", "car", 
						"cat", "care", "laboratory", "ebook"}; 
		String output[] = {"is NOT in the prefix tree", "is in the prefix tree"}; 
	
		root = new TrieNode(); 
	
		// Construct trie 
		int i; 
		for (i = 0; i < words.length ; i++) 
			insert(words[i]); 
	
		// Search for different keys 
		if(search("lab") == true) 
			System.out.println("lab --- " + output[1]); 
		else System.out.println("lab --- " + output[0]); 
		
		if(search("java") == true) 
			System.out.println("java --- " + output[1]); 
		else System.out.println("java --- " + output[0]); 
		
		
		if(startWith("eced") == true) 
			System.out.println("eced --- " + output[1]); 
		else System.out.println("eced --- " + output[0]); 
		
		if(startWith("ca") == true) 
			System.out.println("ca --- " + output[1]); 
		else System.out.println("ca --- " + output[0]); 
		
		if(search("book") == true) 
			System.out.println("book --- " + output[1]); 
		else System.out.println("book --- " + output[0]); 
		
	} 
}



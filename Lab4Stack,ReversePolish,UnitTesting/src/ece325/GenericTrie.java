package ece325;

import ece325.TrieNode;

/**
 * Lab 4: Generics <br />
 * The {@code GenericTrie} class <br />
 * Reference: <a href="https://en.wikipedia.org/wiki/Trie">
 *              https://en.wikipedia.org/wiki/Trie
 *            </a>
 */
public class GenericTrie<K extends CharSequence, V> 
{
		
    /**
     * Root node of the Prefix Tree
     */	 
	 TrieNode<V> root = new TrieNode<V>(); 

    
    public void insert(K word, V value) {
    	// TODO: Insert a new element to the Prefix Tree
    	
    	TrieNode<V> current = root;
    	for (int i = 0; i<word.length(); i++) {
    		int index = word.charAt(i) - 'a';
    		if(current.child[index] == null) {
    			current.child[index] = new TrieNode<V>();
    		}
    		current = current.child[index];
    	}
    	current.value = value;
        
    }
    
    
    public V search(K word) {
    	// TODO: Returns the value associated with the word is in the Prefix Tree
    	
    	ece325.TrieNode<V> current = root;
    	for (int i = 0; i<word.length(); i++) {
    		int index = word.charAt(i) - 'a';
    		if(current.child[index] == null) {
    			return null;
    		}
    		current = current.child[index];
    	}
    	if (current != null && current.isEndOfWord == false) {
    		return current.value;
    	}
    	return null;
    }

    
   
    public boolean startWith(K prefix) {
    	// TODO: Returns if there is any word in the Prefix Tree that starts with the given prefix.

    	TrieNode<V> current = root;
    	for (int i = 0; i<prefix.length(); i++) {
    		int index = prefix.charAt(i) - 'a';
    		if(current.child[index] == null) {
    			return false;
    		}
    		current = current.child[index];
    	}
    	return true;
    }


    public void remove(K word) {
    	// TODO: Removes an element from the Prefix Tree, returning its associated value
    	TrieNode<V> current;
    	for (int j = 0; j<word.length(); j++) {
    		current = root;
	    	for (int i = 0; i<word.length()-j; i++) {  // go through tree
	    		int index = word.charAt(i) - 'a';
	    		
	    		current = current.child[index]; //next node
	    	}
	    	if (j == 0) {
	    		current.isEndOfWord = false;  // very end, remove 

	    	}
	    	else {
	    		int index = word.charAt(word.length()-j)-'a'; //get index
	    		current.child[index] = null; //remove child
	    		boolean branch = false;  // branch to check if it contains index
	    		for(int i = 0; i<26; i++) {  //iterate through
	    			if(current.child[i] != null) {
	    				branch = true;
	    			}
	    		}
	    		if (branch == true) {
	    			j = word.length(); //exits loop, removing nodes are finished
	    		}
	    	}
    	}
    }

}



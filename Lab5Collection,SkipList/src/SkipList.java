import java.util.ArrayList;
import java.util.Random;

/**
 * Lab 5: Java Collection Framework and Skip List <br />
 * The {@code SkipList} class
 * @param <K>           {@code K} key of each skip list node
 * @param <V>           {@code V} value of each skip list node
 */
public class SkipList<K extends Comparable<K>, V> {

    /**
     * The {@code Node} class for {@code SkipList}
     */
    private class Node {
        public K key;
        public V value;
        public ArrayList<Node> forwards = new ArrayList<Node>();
        
        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            for (int i = 0; i < level; i++)
                forwards.add(null);
        }
        public String toString() {
            return String.format("%s(%s,%d)", value, key, forwards.size());
        }
    }

    /**
     * Level of the skip list. An empty skip list has a level of 1
     */
    private int level = 1;
    private Node head = new Node(null, null, 1);
    
    /**
     * Size of the skip list
     */
    private int size = 0;

    /**
     * Insert an new element into the skip list
     * @param key       {@code K} key of the new element
     * @param value     {@code V} value of the new element
     */
    private int random() {
    	int lev = 1;
    	Random r = new Random();
    	while(r.nextBoolean() && lev<= level) lev++;
		return lev;
    	
    }
    public void insert(K key, V value) {
        // TODO: Lab 5 Part 1-1 -- skip list insertion
    	// generate random level
    	int genLevel = random();
    	//Node to insert
    	Node newNode = new Node(key, value, genLevel) ;
    	// Find node to insert per level
    	int currentLevel = level;
    	Node currentNode = head;
    	ArrayList<Node> turnleaf = new ArrayList<Node>();
    	// Temporary node to hold nodes to insert
    	while (currentLevel>0) {
        	Node nextNode = currentNode.forwards.get(currentLevel-1);
	    	if(nextNode == null || nextNode.key.compareTo(key) > 0) {
	    		// if the key is null or key is lower than next key
	    		// go down
	    		turnleaf.add(currentNode);
	   			currentLevel --;
	    	}
	    	else if(nextNode != null && nextNode.key.compareTo(key) < 0) {
	    		// next node
	    		currentNode = nextNode; 
	    	}
	    	else {
	    		// change value, exit
	    		nextNode.value = value;
	    		return;
	    	}
	   	}
    	// Level greater than current level, add node, add level
    	if(genLevel>level) {
   			head.forwards.add(newNode);
   			level = genLevel;
   		}
    	// insert node with the minimum of gen level and leaf size
    	for(int i = 0; i <= Integer.min(turnleaf.size(), genLevel) -1; i++) {
    		currentNode = turnleaf.get(turnleaf.size()-i-1);
    		newNode.forwards.set(i, currentNode.forwards.get(i));
    		currentNode.forwards.set(i, newNode);
    	}
    	size++;
    	}

    
    /**
     * Remove an element by the key
     * @param key       {@code K} key of the element
     * @return          {@code V} value of the removed element
     */
    public V remove(K key) {
        // TODO: Lab 5 Part 1-2 -- skip list deletion
    	//get level
    	int currentLevel = level;
    	// Uses search method to see if it is found
    	if(search(key) == null) {
    		return null;
    	}
    	Node currentNode = head;
    	// Temporary list to hold positions
    	ArrayList<Node> turnleaf = new ArrayList<Node>();
    	while (currentLevel>0) { // search each level
        	Node nextNodeTemp = currentNode.forwards.get(currentLevel-1);
	    	if(nextNodeTemp == null || nextNodeTemp.key.compareTo(key) > 0) {
	    		// if the key is null or key is lower than next key
	    		// go down
	   			currentLevel --;
	    	}
	    	else if(nextNodeTemp != null && nextNodeTemp.key.compareTo(key) < 0) {
	    		
	    		// next node
	    		// selected key is bigger then current node key
	    		currentNode = nextNodeTemp; 
	    	}
	    	else {
	    		// change value, exit
	    		turnleaf.add(currentNode);
	    		currentLevel --;
	    		
	    	}
	   	}
    	// get val
    	V val = null;
    	// Remove node for eaach level
    	for(int i = 0; i <= turnleaf.size() -1; i++) {
    		currentNode = turnleaf.get(turnleaf.size()-i-1);
    		Node nextNode = currentNode.forwards.get(i);
    		val = nextNode.value;
    		currentNode.forwards.set(i, nextNode.forwards.get(i));
    	}
    	// Reduce size
    	size--;
    	// Remove level from head if it does not exist
    	for (int i = level - 1 ; i>=0; i--) {
    		
    		if (head.forwards.get(i) == null) {
    			head.forwards.remove(i);
    			level--;
    		}
    		else {
    			// finished removing, exit loops
    			i = 0;
    		}
    	}
    	return val;
    	
    }

    /**
     * Search for an element by the key
     * @param key       {@code K} key of the element
     * @return          {@code V} value of the target element
     */
    public V search(K key) {
        // TODO: Lab 5 Part 1-3 -- skip list node search
    	// get level
        int currentLevel = level;
        // start at head
        Node currentNode = head;
        while (currentLevel>0) {
        	Node nextNode = currentNode.forwards.get(currentLevel-1);
	    	if(nextNode == null || nextNode.key.compareTo(key) > 0) {
	    		// if the key is null or key is lower than next key
	    		// go down
	   			currentLevel --;
	    	}
	    	else if(nextNode != null && nextNode.key.compareTo(key) < 0) {
	    		// next node
	    		currentNode = nextNode; 
	    	}
	    	else {
	    		// Found it
	    		// return value
	    		return nextNode.value;
	    	}
	   	}
        return null;
    }

    /**
     * Get the level of the skip list
     * @return          {@code int} level of the skip list
     */
    public int level() {
        return level;
    }

    /**
     * Get the size of the skip list
     * @return          {@code int} size of the skip list
     */
    public int size() {
        return size;
    }

    /**
     * Print the skip list
     * @return          {@code String} the string format of the skip list
     */
    public String toString() {
        // TODO: Lab 5 Part 1-4 -- skip list printing
    	String r = "";
    	Node temp = head;
    	// Iterate through node
    	while(temp.forwards.get(0) != null) {
    		r += temp.forwards.get(0).toString() + "\r\n";
    		temp = temp.forwards.get(0);
    	}
    	return r;
    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        SkipList<Integer, String> list = new SkipList<Integer, String>();
        int[] keys = new int[10];
        for (int i = 0; i < 10; i++) {                          // Insert elements
            keys[i] = (int) (Math.random() * 200);
            list.insert(keys[i], "\"" + keys[i] + "\"");
        }

        System.out.println(list);

        for (int i = 0; i < 10; i += 3) {
            int key = keys[i];
            // Search elements
            System.out.println(String.format("Find element             %3d: value=%s", key, list.search(key)));
            // Remove some elements
            System.out.println(String.format("Remove element           %3d: value=%s", key, list.remove(key)));
            // Search the removed elements
            System.out.println(String.format("Find the removed element %3d: value=%s", key, list.search(key)));
        }

        System.out.println(list);
    }

}

import java.util.Vector;

/**
 * Lab 4: Generics <br />
 * The {@code GenericStack} class
 */
public class GenericStack<T> {
	private Vector<T> stack = new Vector<T>();
	private int top = 0;
    /**
     * Query the top element
     * @return          {@code T} the top element
     */
    public T peek() {
        // TODO: Lab 4 Part 1-1 -- GenericStack, finish the peek method
    	return stack.get(top-1);
    }

    /**
     * Add a new element as top element
     * @param value     {@code T} the new element
     */
    public void push(T value) {
        // TODO: Lab 4 Part 1-2 -- GenericStack, finish the push method
    	stack.add(value);
    	top++;
    }

    /**
     * Remove the top element
     * @return          {@code T} the removed element
     */
    public T pop() {
        // TODO: Lab 4 Part 1-3 -- GenericStack, finish the pop method
        top--;
        return stack.remove(top);
        
    }

    /**
     * Query the size of the stack
     * @return          {@code int} size of the element
     */
    public int size() {
        // TODO: Lab 4 Part 1-4 -- GenericStack, finish the size method
        
        return top;
    }

    /**
     * Check if the stack is empty of not
     * @return          {@code boolean} {@code true} for empty; {@code false} for not
     */
    public boolean isEmpty() {
        // TODO: Lab 4 Part 1-5 -- GenericStack, finish the isEmpty method
        
        return stack.isEmpty();
    }

    /**
     * Calculate a postfix expression
     * @param exp       {@code String} the postfix expression
     * @return          {@code Double} the value of the expression
     */
    public static Double calcPostfixExpression(String exp) {
        // TODO: Lab 4 Part 1-6 -- GenericStack, calculate postfix expression
    	GenericStack<Double> stack = new GenericStack<Double>();
    	char[] chars = exp.toCharArray();
    	for (char ch:chars) {
    		if (ch>= '0' && ch<= '9') {
    			stack.push((double)(ch-'0'));
    		}
    		else if (ch!= ' ') {
    			double num1 = stack.pop();
    			double num2 = stack.pop();
    			if(ch == '+') {
    				stack.push(num1+num2);
    			}
    			else if(ch == '-') {
    				stack.push(num2-num1);
    			}
    			else if(ch == '*') {
        			stack.push(num1*num2);
    			}
    			else if(ch == '/') {
        			stack.push(num2/num1);
        		}
    			else if(ch == '^') {
        			stack.push(Math.pow(num2,num1));
        			}
    		}
    		
    	}
    	if (!stack.isEmpty()) {
    		return stack.pop();
    	}
    	else {
    		return null;
    	}
    }

    /**
     * Main entry
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        String[] expressions = {
                "4 1 +",                    // 1: = 5
                "2 6 -",                    // 2: = -4
                "3 3 *",                    // 3: = 9
                "1 4 /",                    // 4: = 0.25
                "2 3 ^",                    // 5: = 8
                "2 1 + 4 * 8 - 3 ^ 6 -",    // 6: 58
        }; // String[] expressions = { ... };
        for (String s: expressions)
            System.out.println(s + " = " + calcPostfixExpression(s));
    }

}

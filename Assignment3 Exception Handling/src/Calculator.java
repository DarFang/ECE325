import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * ECE 325 - Fall 2020 <br/>
 * Assignment 3: Exception handling <br />
 * Calculator using BNF
 * <p>
 * @author Dfang
 */

/**
 * Syntax Error
 */
class  syntaxError extends Exception{
	syntaxError(String s){
		super(s);
	}
}
/**
 * Runtime Error
 */
class runtimeError extends Exception{
	runtimeError(String s){
		super(s);
	}
}
/**
 * Class calculator converts a string of syntax to an integer
 */
public class Calculator {
	/**
	 * Concatenate replaces the old string with the replaced string 
	 * @param exp {@code String} The original string
	 * @param sub {@code String} The string that needs to be replaced inside exp
	 * @param replace {@code int} the value that replaces the replace string
	 * @return exp {@code String} The new string 
	 */
	public String concatenate(String exp, String sub, int replace) {
		Pattern remove = Pattern.compile(sub);
		Matcher m = remove.matcher(exp);
		if(m.find()) {
			exp = exp.substring(0, m.start()) + replace + exp.substring(m.end(), exp.length()) ;
		}
		return exp;
	}
	/**
	 * Get the value of the string if it is a variable found in the hash, 
	 * returns the same number if its a number.
	 * Otherwise it fails
	 * @param val  {@code String} The value to be checked
	 * @param map  {@code HashMap<Character ,Integer>} The hashmap containing the variable values
	 * @return an integer
	 * @throws runtimeError  Throws Runtime error for not finding the value
	 */
	public String getVal (String val, HashMap<Character ,Integer> map) throws runtimeError {
		Pattern number = Pattern.compile("[0-9]");
		Matcher m = number.matcher(val);
		if(m.find()) {
			return val;
		}
		else {
			if (map.get(val.charAt(0)) == null){
				throw new runtimeError("'"+ val.charAt(0) + "' undefined");
			}
			return Integer.toString(map.get(val.charAt(0)));
		}
	}
    /**
     * Execute the expression, and return the correct value
     * Uses recursion every time it replaces a function
     * It first replaces all brackets, then all let =, then operations
     * Throws exceptions if the calculator cannot do the job
     * @param exp           {@code String} The expression string
     * @param map			{@code Hashmap <Character, Integer>} The hash map contain variable values
     * @return              {@code int}    The value of the expression
	 * @throws syntaxError Throws Syntax for input
	 * @throws runtimeError Throws Runtime error
	 **/
    public int execExpression(String exp, HashMap<Character ,Integer> map) throws syntaxError, runtimeError{  	
    	exp = exp.replace(";", ""); // remove ':'
    	Pattern incompletebrack = Pattern.compile("\\((.*)[^\\)]");  // incomplete ()
    	Pattern letnoequ = Pattern.compile("let ([a-zA-Z_]+)([^=])*");  // incomplete = in let
    	Pattern LetStateLet = Pattern.compile("let");
        Pattern innerBracket = Pattern.compile("(\\([^\\(\\)]*\\))");  // has ()
	    Pattern containoperate = Pattern.compile("[+-\\\\*\\\\^]");  // has on of the operators
        Pattern AS = Pattern.compile("[0-9a-z]+ [+-] [0-9a-z]+");  // addition or subtraction
        Pattern M = Pattern.compile("\\*");  // multiplication
        Pattern E = Pattern.compile("\\^");  // power
        Pattern LetState = Pattern.compile("let ([a-zA-Z_]+) = (.*)");  // has let = a
        Pattern Le = Pattern.compile("le[^t]");  // let statement spelled wrong
        Matcher m = innerBracket.matcher(exp);
        if (m.find()) {  // has ()
			String sub =  exp.substring(m.start()+1, m.end()-1);  //remove bracket
			int replace = execExpression(sub, map);  // get value
			m = containoperate.matcher(sub);  // does it have an operation
			if(m.find()) {
				if(sub.indexOf('+') > 0) {  // edit string to have _\\+_
					sub = sub.substring(0, sub.indexOf("+")) + "\\" + sub.substring(sub.indexOf("+"), sub.length());
				}	
			}
			exp = concatenate(exp,"\\(" + sub + "\\)", replace); // new exp
			return execExpression(exp, map);  // recurse
		}
        m = LetState.matcher(exp);
        if (m.find()) {  // has let = a
        	String sub =  exp.substring(m.start(), m.end());
        	char var = exp.charAt(4); // variable
        	String valc = exp.substring(8, exp.length());  // get value
        	m = LetStateLet.matcher(valc);  // Throws double let statement
            if(m.find()) {
            	throw new syntaxError("')' expected");
            }
        	int val = 0;
        	if(valc.length() == 1) {
        		val = Integer.parseInt(getVal(valc, map));  // if its just 1 value/variable
        	}
        	else {
        		val = execExpression(valc, map);  // Find the value
        		sub = sub.substring(0, sub.indexOf("+")) + "\\" + sub.substring(sub.indexOf("+"), sub.length()); // change string
        	}
        	map.put(var, val);  // put in hash map
        	exp = concatenate(exp, sub, val);  // new exp
        	return execExpression(exp, map);  // recurse
        }
        m = E.matcher(exp);
        if (m.find()) {  // exponent operator
        	String sub = exp.substring(m.start()-2, m.end()+2);  // get string
        	String temp = sub.replace(" ^", "");
        	String[] val= temp.split(" ");  // get 2 vals
        	sub = val[0] + " \\^ " + val[1];  // change string
        	int out =  (int) Math.pow(Integer.parseInt(val[0]), Integer.parseInt(val[1]));  // operation
        	exp = concatenate(exp, sub, out);  // new exp
        	return execExpression(exp, map);  // recurse
        }
        m = M.matcher(exp);
        if (m.find()) {  // multiply operator
        	String sub = exp.substring(m.start()-2, m.end()+2);  // get string
        	String temp = sub.replace(" *", "");
        	String[] val= temp.split(" ");  // get 2 vals
        	sub = val[0] + " \\* " + val[1];  // change string
         	int out =  (int) (Integer.parseInt(val[0]) * Integer.parseInt(val[1]));  // operation
        	exp = concatenate(exp, sub, out);  // new exp
        	return execExpression(exp, map);  // recurse
        }
        m = AS.matcher(exp);
        if (m.find()) {  // add or sub operator
        	String sub = exp.substring(m.start(), m.end());  // get string
        	if(sub.indexOf('+') > 0) { // plus
        		String temp = sub.replace(" +", "");
        		String[] val= temp.split(" ");  // get both val
        		sub = val[0] + " \\+ " + val[1];  // change string
        		val[0] = getVal(val[0], map);  // variable check
        		val[1] = getVal(val[1], map);
        		int out =  (int)(Integer.parseInt(val[0]) + Integer.parseInt(val[1]));  // operate
        		exp = concatenate(exp, sub, out);  // new exp
        		return execExpression(exp, map);  // recurse
        	}
        	else{  // minus
        		String temp = sub.replace(" -", "");  // get string
        		String[] val= temp.split(" ");
        		sub = val[0] + " \\- " + val[1];  // change string
        		val[0] = getVal(val[0], map);  //variable check
        		val[1] = getVal(val[1], map);
        		int out =  (int)(Integer.parseInt(val[0]) - Integer.parseInt(val[1]));  //operate
        		exp = concatenate(exp, sub, out);  // new exp
        		return execExpression(exp, map);  // recurse
        	}
        }
        m = incompletebrack.matcher(exp);
        if(m.find()) { // if (, no )
        	throw new syntaxError("')' expected" );
        }
        m = letnoequ.matcher(exp);
        if(m.find()) { // if let a b, no =
        	throw new syntaxError("'=' expected" );
        }
        m = Le.matcher(exp);
        if(m.find()) {
        	throw new runtimeError("'ler' undefined");
        }
        if(exp.length()>2) {//operation error
        	throw new syntaxError("operator expected" );
        }
        return Integer.parseInt(exp); // returns a single int if successful
    }
    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // Part 1
        String[] inputs = {
            "let x = 1;",                                                                           // 1, returns 1
            "(let x = 1) + x;",                                                                     // 2, returns 2
            "(let a = 2) + 3 * 2 - 5;",                                                             // 3, returns 3
            "(let x = (let y = (let z = 1))) + x + y + z;",                                         // 4, returns 4
            "1 + (let x = 1) + (let y = 2) + (1 + x) * (1 + y) - (let x = y) - (let y = 1) - x;",   // 5, returns 5
            "1 + (let a = (let b = 1) + b) + a + 1;",                                               // 6, returns 6
            "(let a = (let a = (let a = (let a = 2) + a) + a) + a) - 9;",                           // 7, returns 7
            "(let x = 2) ^ (let y = 3);",                                                           // 8, returns 8
            "(let y = 3) ^ (let x = 2);"                                                            // 9, returns 9
        };
        for (int i = 0; i < inputs.length; i++) {
        	try {
	        	HashMap <Character ,Integer> map = new HashMap <Character ,Integer>();
	            System.out.println(String.format("%d -- %-90s %d", i+1, inputs[i], calc.execExpression(inputs[i], map)));
        
        		}
        	catch(Exception e){
        		System.out.println(e);
        	}
        }
        inputs = new String[] {
                "1 + (2 * 3;",                  // 1, syntax error: ')' expected
                "(let x 5) + x;",               // 2, syntax error: '=' expected
                "(let x = 5) (let y = 6);",     // 3, syntax error: operator expected
                "(let x = 5let y = 6);",       // 4, syntax error: ')' expected
                "(ler x = 5) ^ (let y = 6);",   // 5, runtime error: 'ler' undefined
                "(let x = 5) + y;"              // 6, runtime error: 'y' undefined
        };
	        for (int i = 0; i < inputs.length; i++) {
	        	try {
		        	HashMap <Character ,Integer> map = new HashMap <Character ,Integer>();
		            System.out.println(String.format("%d -- %-30s %d", i+1, inputs[i], calc.execExpression(inputs[i], map)));
	        	}
	        
	        	catch(Exception e){
	        		System.out.println(e);
	        	}
	        }
    	}
    }
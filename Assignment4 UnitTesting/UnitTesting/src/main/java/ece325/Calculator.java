package ece325;

/**
 * Assignment 4 Part 2: Unit Testing <br />
 * The calculator to run the test cases
 */
// TODO: Assignment 4 Part 2 -- Create the Calculator here


public class Calculator{
	
	public Double add(Object x, Object y) {
		if (x instanceof Integer) {
			Double x1 = new Double((Integer)x);
			Double y1 = new Double((Integer)y);
			return x1+y1;
		}
		return (Double)x + (Double)y;
	}
	
	public Double subtract(Object x, Object y) {
		if (x instanceof Integer) {
			Double x1 = new Double((Integer)x);
			Double y1 = new Double((Integer)y);
			return x1 - y1;
		}
		return (Double)x - (Double)y;
	}
	
	public Double multiply(Object x, Object y) {
		if (x instanceof Integer) {
			Double x1 = new Double((Integer)x);
			Double y1 = new Double((Integer)y);
			return x1 * y1;
		}
		return (Double)x * (Double)y;
	}
	
	public Double divide(Object x, Object y) {
		if (x instanceof Integer) {
			Double x1 = new Double((Integer)x);
			Double y1 = new Double((Integer)y);
			return x1 / y1;
		}
		return (Double)x / (Double)y;
	}
	public Double[] getRoots(Double a, Double b,  Double c) {
		Double d = Math.pow(b,2.0) - 4*a*c;
		if (d > 0.0) {
			Double[] root = new Double[2];
			root[0] = (-b + Math.sqrt(d))/(2*a);
			root[1] = (-b - Math.sqrt(d))/(2*a);
			return root;
		}
		else if (d == 0.0) {
			Double[] root = new Double[1];
			root[0] = -b/(2*a);
			return root;
		}
		else {
			Double[] root = new Double[2];
			root[0] = Double.NaN;
			root[1] = Double.NaN;
			return root;
		}
	}
	public Double squareRoot(Double x) {
		if (x >= 0.0) {
			return Math.sqrt(x);
		}
		else {
			return Double.NaN;
		}
		
	}
	
	
	
}
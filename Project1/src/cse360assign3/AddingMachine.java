/**
 * Class that adds and subtracts numbers.
 * Class ID: 85141
 * @author Omer Abdelsalam
 * @version 1.0
 */
package cse360assign3;

import java.util.*;
public class AddingMachine {

	protected double total;
	protected ArrayList<Integer> flag = new ArrayList<Integer>();
	protected ArrayList<Integer> values = new ArrayList<Integer>();
	
	/**
	 * Constructor for the class. Sets the total to zero.
	 */
	public AddingMachine () {
		total = 0;  // not needed - included for clarity
	}
	
	/**
	 * This method returns the current value of the total.
	 * @return total
	 */
	public double getTotal () {
		return total;
	}
	
	/**
	 * This method adds the parameter value to the total variable.
	 * Addition is remembered by a 1 in the flag arraylist.
	 * @param value Integer parameter that gets added to the total.
	 */
	public void add (int value) { // Addition gets flagged by 1
		this.total = total + value;
		flag.add(1);
		values.add(value);
	}
	
	/**
	 * This method subtracts the parameter value to the total variable.
	 * Subtraction is remembered by a 2 in the flag arraylist.
	 * @param value Integer parameter that gets subtracted to the total.
	 */
	public void subtract (int value) { // Subtraction gets flagged by 2
		this.total = total - value;
		flag.add(2);
		values.add(value);
	}
		
	/**
	 * toString method that uses a string builder to make the return string.
	 * @return Returns a string with the "history" of addition and subtraction.
	 */
	public String toString () {
		String result;
		StringBuilder str = new StringBuilder();
		str.append(0);
		int i = 0;
		while(i < values.size()) {
			if(flag.get(i) == 1) {
				str.append(" + ");
			} else {
				str.append(" - ");
			}
			str.append(values.get(i));
			i++;
		}
		result = str.toString();
		return result;
	}

	/**
	 * Clears the adding machine object. Sets total to 0.
	 * Clears the flag arraylist as well as the values arraylist.
	 */
	public void clear() {
		this.total = 0;
		flag.clear();
		values.clear();
	}
}

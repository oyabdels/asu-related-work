/**
 * Extension to the AddingMachine Class.
 * Divides and multiplies numbers.
 * Class ID: 85141
 * @author Omer Abdelsalam
 * @version 1.0
 */
package cse360assign3;

public class Calculator extends AddingMachine{
	
	/**
	 * Constructor for the class. Calls the super() reference to 
	 * refer to the parent class. Sets the total to zero.
	 */
	public Calculator() {
		super();
	}
	
	/**
	 * This method multiplies the total variable by the value parameter.
	 * Multiplication is remembered by a 3 in the flag arraylist.
	 * @param value Integer parameter that gets multiplied to the total.
	 */
	public void multiply (int value) { // Multiplication gets flagged by 3
		super.total = total * value;
		super.flag.add(3);
		super.values.add(value);
	}
	
	/**
	 * This method divides the total variable by the value parameter.
	 * If the parameter is a zero, we set total to zero. (Cant divide by zero)
	 * Division is remembered by a 4 in the flag arraylist.
	 * @param value Integer parameter that the total gets divided by.
	 */
	public void divide (int value) { // Division gets flagged by a 4
		if(value == 0) {
			super.total = 0;
			super.flag.add(4);
			super.values.add(value);
		} else {
			super.total = total / value;
			super.flag.add(4);
			super.values.add(value);
		}
	}
	
	/**
	 * This method raises the total to the power of value.
	 * If the parameter is a negative, we set the total to zero.
	 * Power is remembered by a 4 in the flag arraylist.
	 * @param value Integer value that the total gets raised by.
	 */
	public void power (int value) { // Power gets flagged by a 5
		if(value < 0) {
			super.total = 0;
			super.flag.add(5);
			super.values.add(value);
		} else if(value > 0) {
			super.total = Math.pow(total, value);
			super.flag.add(5);
			super.values.add(value);
		} else {
			super.total = 1;
			super.flag.add(5);
			super.values.add(value);
		}
	}
	
	/**
	 * toString method that uses a string builder to make the return string.
	 * @return Returns a string with the "history" of the methods.
	 */
	public String toString () {
		String result;
		StringBuilder str = new StringBuilder();
		for(int j = 0; j<values.size(); j++) {
			str.append("(");
		}
		str.append(0);
		int i = 0;
		while(i < values.size()) {
			
			if(flag.get(i) == 1) {
				str.append(" + ");
			} else if(flag.get(i) == 2) {
				str.append(" - ");
			} else if(flag.get(i) == 3) {
				str.append(" * ");
			} else if(flag.get(i) == 4) {
				str.append(" / ");
			} else if(flag.get(i) == 5) {
				str.append(" ^ ");
			}
			str.append(values.get(i));
			str.append(")");
			i++;
		}
		result = str.toString();
		return result;
	}
}

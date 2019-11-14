/**
 * This class tests if strings are palindromes.
 * @author Omer Abdelsalam
 * @version 1.0
 */
package assign1;

public class Palindrome {
	private String testString;
	
	/**
	 * Constructor of the palindrome class. Takes an input string
	 * and removes all special characters and spaces, turns them to 
	 * lowercase, and stores it into testString.
	 * @param str the string you want to add to the palindrome object.
 	 */
	public Palindrome( String str ) {
		testString = str.replaceAll("[^a-zA-Z0-9]+" , "").toLowerCase();
	}
	
	/**
	 * Method that checks if the string in your object is a palindrome.
	 * @return returns true if the string is a palindrome and false if otherwise.
	 */
	public boolean isPalindrome() {
		int forward = 0;
		int backward = testString.length()-1;
		boolean palin = true;
		while((forward != (testString.length()/2)) && palin == true) {		
			if(testString.charAt(forward) != testString.charAt(backward)) {
				palin = false;
			}
			forward++;
			backward--;
		}
		return palin;
	}
}

//Omer Abdelsalam
package assign1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeTest {

	/**
	 * Tests if white spaces will be excluded from palindromes.
	 * @exclude
	 */
	@Test
	void test1() {
		Palindrome palin = new Palindrome("race  car");
		boolean expected = true;
		boolean actual = palin.isPalindrome();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests if special characters will be excluded from palindromes.
	 * @exclude
	 */
	@Test
	void test2() {
		Palindrome palin = new Palindrome("race,car");
		boolean expected = true;
		boolean actual = palin.isPalindrome();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests if numbers can be included as palindromes.
	 * @exclude
	 */
	@Test
	void test3() {
		Palindrome palin = new Palindrome("r3acecar");
		boolean expected = false;
		boolean actual = palin.isPalindrome();
		assertEquals(expected, actual);
	}

	/**
	 * Tests if a sentence counts as a palindrome.
	 * @exclude
	 */
	@Test
	void test4() {
		Palindrome palin = new Palindrome("1Madam Im Adam1");
		boolean expected = true;
		boolean actual = palin.isPalindrome();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests if an empty string counts as a palindrome
	 * @exclude
	 */
	@Test
	void test5() {
		Palindrome palin = new Palindrome("");
		boolean expected = true;
		boolean actual = palin.isPalindrome();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests if a single character counts as a palindrome
	 * @exclude
	 */
	@Test
	void test6() {
		Palindrome palin = new Palindrome("7");
		boolean expected = true;
		boolean actual = palin.isPalindrome();
		assertEquals(expected, actual);
	}
}

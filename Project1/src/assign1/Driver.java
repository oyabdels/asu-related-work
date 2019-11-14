package assign1;
import java.util.*;

public class Driver {
	public static void main(String args[]) {
		Scanner kb = new Scanner(System.in);
		String str;
		System.out.println("Enter a string: ");
		str = kb.nextLine();
		System.out.println();
		Palindrome palin = new Palindrome(str);
		System.out.println("Is your string a palindrome? ");
		System.out.println(palin.isPalindrome());
	}
}

package cse360assign2;
import java.util.*;

public class Driver {
	public static void main(String args[]) {
		AddingMachine calc = new AddingMachine();
		AddingMachine calc2 = new AddingMachine();
		calc.add(1);
		calc.add(2);
		calc.subtract(3);
		calc.subtract(4);
		calc.add(5);
		calc.subtract(6);
		calc.add(7);
		System.out.print("Total: ");
		System.out.println(calc.getTotal());
		System.out.print("Expression: ");
		System.out.println(calc.toString());
		calc2.add(1);
		calc2.add(1);
		calc2.subtract(1);
		calc2.clear();
		System.out.print("Total: ");
		System.out.println(calc2.getTotal());
		System.out.print("Expression: ");
		System.out.println(calc2.toString());
	}
}
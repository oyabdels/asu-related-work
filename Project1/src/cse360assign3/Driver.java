package cse360assign3;

import cse360assign2.AddingMachine;

public class Driver {
	public static void main(String[] args) {
		AddingMachine addm = new AddingMachine();
		Calculator calc = new Calculator();
		addm.add(2);
		addm.subtract(3);
		addm.subtract(4);
		addm.add(5);
		addm.subtract(6);
		addm.add(7);
		System.out.print("Total: ");
		System.out.println(addm.getTotal());
		System.out.print("Expression: ");
		System.out.println(addm.toString());
		calc.add(2);
		calc.multiply(3);
		calc.subtract(4);
		calc.multiply(5);
		calc.divide(2);
		calc.power(3);
		System.out.print("Total: ");
		System.out.println(calc.getTotal());
		System.out.print("Expression: ");
		System.out.println(calc.toString());
		calc.clear();
		System.out.print("Total: ");
		System.out.println(calc.getTotal());
		System.out.print("Expression: ");
		System.out.println(calc.toString());
		calc.multiply(3);
		calc.add(2);
		calc.power(-2);
		calc.divide(33);
		calc.add(2);
		calc.add(-1);
		System.out.print("Total: ");
		System.out.println(calc.getTotal());
		System.out.print("Expression: ");
		System.out.println(calc.toString());
	}
}

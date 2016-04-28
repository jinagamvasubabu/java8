/**
 * 
 */
package com.demo.part1;

@FunctionalInterface
interface ScientificCalculator {
	public int add(int a, int b);

	default void sub(int a, int b) {
		System.out.println("Value is:" + (a - b));
	}

	public static void getCalculatorName() {
		System.out.println("Scientific Calculator");
	}
}

class superScientificCal implements ScientificCalculator {

	@Override
	public int add(int a, int b) {
		return b + a;
	}

}

public class FunctionalinterfacesEx {

	public static void add(ScientificCalculator cal) {
		System.out.println(cal.add(10, 20));
	}

	public static void getCalcName() {
		ScientificCalculator.getCalculatorName();
	}

	public static void main(String[] args) {
		add(new ScientificCalculator() {

			@Override
			public int add(int a, int b) {
				return a + b;
			}
		});

		ScientificCalculator.getCalculatorName();

		superScientificCal obj2 = new superScientificCal();
		obj2.sub(20, 10);
	}

}

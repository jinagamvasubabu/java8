package com.vasu.lambda;

@FunctionalInterface
interface Calculator {
	public void scientficSum(int a,int b);
	//public void sub(int a,int b); // does not allow more than one abstract method!!!
	default void  sub(int a,int b){
		System.out.println(a-b);
	}
	public static String getName(){ // which cannot be overrided!!!! :(
		return "Scientific Calculator";
	}
}

public class FunctionalInterfacesEx {

	public static void callScientificAdd(Calculator c) {
		c.scientficSum(10,20);
	}
	public static void main(String[] args) {
		callScientificAdd(new Calculator() {
			
			@Override
			public void scientficSum(int a, int b) {
				System.out.println("Complex sum value is using old and boring way!!!: "+ (a+b));
			}
		});
		
		callScientificAdd( (a,b) -> System.out.println("Complex sum value is using Functional way!!!: "+ (a+b)));
		
		
		
	}

}

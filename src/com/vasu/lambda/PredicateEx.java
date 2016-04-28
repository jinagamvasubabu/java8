package com.vasu.lambda;

import java.util.function.Predicate;

public class PredicateEx {
	public static void main(String[] args) {
		String s1 = "vasubabu";
		
		/*Predicate<String> p1 = new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.length() > 4;
			}
		};*/
		
		Predicate<String> p1 = s -> s.length() > 4;
		Predicate<String> p2 = s -> s.length() > 7;
		Predicate<String> p3 = p1.and(p2);
		
		//dig in and method of predicate its a default method
		System.out.println(p3.test(s1));
	}
}

package com.vasu.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterEx {

	public static void main(String[] args) {
		List<String> cList = Arrays.asList("one","two","three","four","five");
		Predicate<String> p1 = p -> p.length() > 2; 
		Predicate<String> p2 = Predicate.isEqual("two");
		cList.stream().
				filter(p1.and(p2)).
				forEach(System.out::println);
	}
}

package com.demo.part1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaEx {

	public static void main(String[] args) {
		System.out.println("In Main Thread!!!");
		
		Thread th = new Thread(() -> System.out.println("In Child Thread !!!"));
		th.start();
		 
		 Comparator<String> comp = (String o1, String o2) ->  Integer.compare(o1.length(), o2.length());
		
		List<String> stars = Arrays.asList("***","**","*","****");
		Collections.sort(stars,comp);
		
		for(String i: stars){
			System.out.println(i);
		}
		
		stars.stream()
			// .forEach((s) -> System.out.println(s));
				.forEach(System.out::println);
	}

}

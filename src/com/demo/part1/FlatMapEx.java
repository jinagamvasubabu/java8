package com.demo.part1;

import java.util.Arrays;
import java.util.List;

public class FlatMapEx {

	public static void main(String[] args) {
		
		List<Integer> l1 = Arrays.asList(1,2,3);

		List<Integer> l2 = Arrays.asList(1,2,3);

		List<Integer> l3 = Arrays.asList(1,2,3);
		
		
		List<List<Integer>> numbers = Arrays.asList(l1,l2,l3);
		
		numbers.stream()
				//.map(i -> i.size())
				.flatMap(l -> l.stream())
				.forEach(System.out::print);
	}

}

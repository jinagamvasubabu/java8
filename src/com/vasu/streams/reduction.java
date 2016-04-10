package com.vasu.streams;

import java.util.Arrays;
import java.util.List;

public class reduction {
	public static void main(String[] args) {
		List<Integer> itemsList = Arrays.asList(101,101,201,201);
		
		Boolean result = itemsList.stream().
					map(i -> (i%2)).
					allMatch(i -> i!=0);
		
		System.out.println(result);
		
	}
}

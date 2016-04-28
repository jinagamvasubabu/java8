package com.vasu.lambda.devoxx;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class Iterators {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);	
	/*	//External Iterators
		for(int i : numbers){
			System.out.println(i);
		}
		
		//Internal Iterators
	
		
		numbers.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		}); */
		
		//numbers.forEach((i) -> System.out.println(i));
		//numbers.forEach(i -> System.out.println(i));
		//numbers.forEach(System.out::println);
		
		
		// method references
		numbers.stream().
				//map(i -> Integer.toString(i))
				map(String::valueOf)
				//.forEach((i) -> System.out.println(i));
				.forEach(System.out::println);
		
		String result = numbers.stream().
				map( e-> e.toString()).
				reduce("",new BinaryOperator<String>(){

					@Override
					public String apply(String t, String u) {
						// TODO Auto-generated method stub
						return t+u;
					}});
		
		System.out.println(result);
		
		String result2 = numbers.stream().
				map( e-> e.toString()).
				//reduce("",(res, e) -> res+e);
				//reduce("", (res,e) -> res.concat(e));
				reduce("", String::concat);
		
		System.out.println(result2);
				
		
	}

}

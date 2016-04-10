package com.vasu.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx {
	public static void main(String[] args) {
		List<String> items = Arrays.asList("vasu","santhosh","srinu","prasanna","nataraj");
		List<String> result = new ArrayList<>();
		
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = result::add;
		
		items.forEach(c1.andThen(c2));
		System.out.println("result is :"+ result.size());
		
	}
}

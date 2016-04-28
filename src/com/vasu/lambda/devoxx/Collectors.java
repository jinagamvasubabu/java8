package com.vasu.lambda.devoxx;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class Collectors {

	public static void main(String[] args) {
		List<Customer> customers = Arrays.asList(
											new Customer("vasu",20),
											new Customer("hari",23),
											new Customer("srinu",16),
											new Customer("vasu",20),
											new Customer("hari",22),
											new Customer("phani",17),
											new Customer("srinu",18)
								 	);
		Map<String, Set<Integer>> personsMap = 
				customers.stream()
						 .collect(groupingBy(Customer::getName,mapping(Customer::getAge, toSet())));
		
		System.out.println(personsMap);
		
		
		//Find the double of the first even number greater than 3
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3);
		System.out.println(numbers.stream()
									.filter(i -> i >3)
									.sorted()
									.distinct()
									.filter(i -> i%2 == 0)
									.map(i -> i*2)
									
									.findFirst()
						);
	}

}

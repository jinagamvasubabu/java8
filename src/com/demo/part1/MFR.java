package com.demo.part1;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;



class Customer {
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}

	private String name;
	private int age;

	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class MFR {

	public static void main(String[] args) {
		List<Customer> Customers = Arrays.asList(
				new Customer("vasu",20),
				new Customer("hari",23),
				new Customer("pavan",23),
				new Customer("srinu",16),
				new Customer("nataraj",21),
				new Customer("siddu",22),
				new Customer("santosh",17),
				new Customer("prasanna",20)
			);
		
		//1. I want the people whose age is greater than 18 and collect it in a list
		System.out.println(Customers.stream()
				.filter((p) -> p.getAge() > 18)
				.map((p) -> p.getName())
				.collect(Collectors.toCollection(LinkedHashSet::new)));
		
		//2. I want the total ages of people whose age is greater than 18
		System.out.println(Customers.stream()
									.filter(p -> p.getAge() > 18)
									.map(Customer::getAge)
									.reduce(0,(total,c) -> total+c));
		
		// 3. the top one in much simple way
		System.out.println(Customers.stream()
									.filter(p -> p.getAge() > 18)
									.mapToInt(Customer::getAge)
									.sum()
						 );
		
	     //4. create a map of age as key and the list of customers
		System.out.println(Customers.stream()
				 .collect(Collectors.groupingBy(Customer::getAge)));
		
		//5. create a map of age as a key and name of the persons 
		System.out.println(Customers.stream()
				 .collect(Collectors.groupingBy(Customer::getAge,mapping(Customer::getName, toSet()))));
		
		
		
	}

}

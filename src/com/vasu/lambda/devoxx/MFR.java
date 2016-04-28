package com.vasu.lambda.devoxx;

import java.util.Arrays;
import java.util.List;


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
													new Customer("srinu",16),
													new Customer("vasu",21),
													new Customer("hari",22),
													new Customer("phani",17),
													new Customer("srinu",18)
												);
		
		String result = Customers.stream()
				.filter( c -> c.getAge() > 18)
				.map(c -> c.getName())
				.reduce("", (carry,c) -> (carry+c));
		
		Integer total = Customers.stream()
								.filter(c -> c.getAge() > 18)
								.map(c->c.getAge())
								.reduce(0, (tot,c) -> Integer.sum(tot, c));
		
		Integer total2 = Customers.stream()
				.filter(c -> c.getAge() > 18)
				.mapToInt(Customer::getAge)
				.sum();
		
		System.out.println(total);
		System.out.println(total2);
		System.out.println(result);
		
		// requirement is 
	}

}

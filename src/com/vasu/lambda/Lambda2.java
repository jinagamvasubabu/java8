package com.vasu.lambda;

import java.util.Arrays;
import java.util.List;

class Customer {
	public Customer(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	private int number;
	private String name;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [number=" + number + ", name=" + name + "]";
	}
	
	
	
}
public class Lambda2 {
	public static void main(String[] args) {
		//List<Customer> cList = Arrays.asList(new Customer(1,"vasu"),new Customer(2,"santhosh"));
		List<Customer> cList = Arrays.asList(new Customer(1,"vasu"),new Customer(2,"santhosh"));
		cList.forEach(customer -> System.out.println(customer));
		//much more simpler 
		cList.forEach(System.out::println);
	}
}

package com.vasu.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
	private int age;
	private String name;
	
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public Person(Person t) {
		this.age = t.getAge();
		this.name = t.getName();
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}	
	
}
public class reduction {
	public static void main(String[] args) {
		
		//First scenario :
		// I want persons average whose age is more than 20
		List<Person> pList = Arrays.asList(new Person(26, "vasu"),new Person(30,"natraj"),new Person(26,"santhosh"),new Person(25,"srinu"));
		
		
		//pList.parallelStream()
		List<Person> updatedList = pList.stream().
				filter(c -> c.getAge() > 25).
				/*map(new Function<Person,Person>(){

					@Override
					public Person apply(Person t) {
						return new Person(t);
					}
					
				});*/
				//map(p -> new Person(p));
				map(Person::new).
				//collect(Collectors.toList());
				collect(Collectors.toCollection(ArrayList::new));
		
		
		String persons = pList.stream().
				filter(c->c.getAge() > 20).
				//map(p -> p.getName()).
				map(Person::getName).
				collect(Collectors.joining(","));
		
		Map<Integer, List<Person>> pMap = pList.stream().
												filter(p -> p.getAge() > 20).
												collect(Collectors.groupingBy(Person::getAge));
												
		
		System.out.println(persons);
		
		System.out.println(updatedList);
		
		System.out.println(pMap);
				
	}
}

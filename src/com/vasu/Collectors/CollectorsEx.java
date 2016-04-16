package com.vasu.Collectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
	private int age;
	private String name;
	
	
	public Person(String name, int age) {
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

public class CollectorsEx {

	public static void main(String[] args) {
		List<Person> pList = new ArrayList<>();
		
		try(BufferedReader reader = 
				new BufferedReader(
						new InputStreamReader(CollectorsEx.class.getResourceAsStream("data.txt")));
				Stream<String> stream = reader.lines();
				)
		{
			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(),Integer.parseInt(s[1].trim()));
				pList.add(p);
				return p;
			}).forEach(System.out::println);
			
			//min age with optional 
			Optional<Person> opt = 
					pList.stream().
					//filter(p -> p.getAge() > 56).
					min(Comparator.comparing(Person::getAge));
			System.out.println(opt);
			
			//max age with optional 
			Optional<Person> opt2 = 
					pList.stream().
					//filter(p -> p.getAge() > 56).
					max(Comparator.comparing(Person::getAge));
			System.out.println(opt2);		
			
			//groupingby age
			Map<Integer, List<Person>> pMap = pList.stream().
												collect(Collectors.groupingBy(p->p.getAge()));
			
			System.out.println(pMap);
			
			//groupingby age and returns List<String> instead of List<Person>
			Map<Integer, List<String>> pMap2 = pList.stream().
					collect(Collectors.groupingBy(Person::getAge,
							Collectors.mapping(Person::getName, Collectors.toList())));

			System.out.println(pMap2);
			
			//grouping by age and returns number of people
			Map<Integer, Long> pMap3 = pList.stream().
					collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));
			
			System.out.println(pMap3);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}

}

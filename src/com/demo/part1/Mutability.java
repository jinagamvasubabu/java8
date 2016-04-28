package com.demo.part1;

class Person {
	private String name;
	private Integer id;
	
	public Person(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
	
}
public class Mutability {

	public static void main(String[] args) {
		Person p = new Person("vasu",1);
		System.out.println("Before Magic:"+p);
		iAmMagic(p);
		System.out.println("After Magic:"+p);
	}
	
	public static void iAmMagic(Person p2) {
		p2.setId(11);
		p2.setName("Vasu got changed!!!");
	}
	
}



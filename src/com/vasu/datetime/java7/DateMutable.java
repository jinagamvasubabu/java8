package com.vasu.datetime.java7;

import java.util.Date;

class Student {
	private String name;
	private Date DOB;
	
	
	public Student(String name, Date dOB) {
		super();
		this.name = name;
		DOB = dOB;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDOB() {
		//return DOB;
		return new Date(this.DOB.getTime()); //defensive copy
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", DOB=" + DOB + "]";
	}
	
	
}
public class DateMutable {

	public static void main(String[] args) {
		Student c1 = new Student("vasu",new Date(2016,1,1));
		
		Date d= c1.getDOB();
		d.setTime(0L);
		
		System.out.println(c1); //it is mutable
		
		//how to prevent that. we will use defensive copy 
		
		
	}

}

package com.demo.part2.jav8;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateEx {

	public static void main(String[] args) {
		LocalDate dob = LocalDate.of(1989, Month.JUNE, 22); // clear month representations
		
		//period
		Period years = dob.until(LocalDate.now());
		System.out.println("Vasu is:"+years.getYears()+" years old!!!");
		
		long months = dob.until(LocalDate.now(),ChronoUnit.MONTHS);
		System.out.println("Vasu is:"+months+" months old!!!");
		
		//to check clearly in years,months,days
		
		Period p1 = Period.between(dob, LocalDate.now());
		System.out.println("Vasu is"+p1.get(ChronoUnit.YEARS)+" years and "+p1.get(ChronoUnit.MONTHS)
		+" months,"+p1.get(ChronoUnit.DAYS)+" Days old");
	}

}

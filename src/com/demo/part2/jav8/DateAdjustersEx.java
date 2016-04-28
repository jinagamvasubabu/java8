package com.demo.part2.jav8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateAdjustersEx {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("Next sunday is on:"+nextSunday);
		
		LocalDate firstSundayInMonth = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
		System.out.println(firstSundayInMonth);
	}

}

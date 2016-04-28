package com.vasu.datetime.jav8;

import java.time.LocalTime;

public class LocalTimeEx {

	public static void main(String[] args) {
		LocalTime l = LocalTime.of(23,53);
		LocalTime l2 = l.plusHours(7);
		
		System.out.println(l2);
	}

}

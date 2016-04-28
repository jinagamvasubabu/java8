package com.vasu.datetime.java7;

import java.sql.Date;
import java.util.Calendar;

public class Java7DateTime {

	public static void main(String[] args) {
		Date d = new Date(2016,1,1); // 2016+1900
		System.out.println(d.toString());
		
		
		Calendar c = Calendar.getInstance();
		c.set(2016, 00, 10, 0, 0, 0);
		System.out.println(c.getTime());
		
		// add 7 days to c
		c.add(Calendar.DAY_OF_MONTH, 7);
		System.out.println(c.getTime());
	}
}

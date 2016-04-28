/**
 * 
 */
package com.vasu.datetime.jav8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ZonedTime {
	public static void main(String[] args) {
		Set<String> zonIds = ZoneId.getAvailableZoneIds();
		//System.out.println(zonIds);
		
		ZonedDateTime IndiaMeeting = ZonedDateTime.of(
									LocalDate.of(2016, Month.APRIL, 29),
									LocalTime.of(15, 30),
									ZoneId.of("Asia/Kolkata"));
		
		ZonedDateTime UkMeeting = IndiaMeeting.withZoneSameInstant(ZoneId.of("Europe/London"));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(IndiaMeeting));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(UkMeeting));
		
		
		
	}

}

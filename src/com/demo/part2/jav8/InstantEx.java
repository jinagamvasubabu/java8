package com.demo.part2.jav8;

import java.time.Duration;
import java.time.Instant;

public class InstantEx {

	public static void main(String[] args) {
		
		Instant start = Instant.now();
		
		for(Long i = 0L; i <1000000000L;){
			i++;
		}
		
		Instant end = Instant.now();
		
		Duration d = Duration.between(start, end);
		System.out.println(d.getSeconds());
	}

}

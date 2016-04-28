package com.demo.part1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousEx {

	public static void main(String[] args) {
		System.out.println("In Main Thread!!!");
		
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("In Child Thread !!!");
			}
		});
		 th.start();
		 
		 Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		List<String> stars = Arrays.asList("***","**","*","****");
		Collections.sort(stars,comp);
		
		for(String i: stars){
			System.out.println(i);
		}
	}

}

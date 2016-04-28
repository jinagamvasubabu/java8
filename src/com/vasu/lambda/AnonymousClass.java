package com.vasu.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClass {

	public static void main(String[] args) {
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};
		
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		File dir = new File("/Users/mac/Documents/workspace/Javaaa/Java8/src/com/vasu/lambda");
		File[] listFiles = dir.listFiles(filter);
		for(File f: listFiles){
			System.out.println(f.getName());
		}
		
		List<String> strList = Arrays.asList("***","**","****","*");
		Collections.sort(strList,comp);
		
		for(String str:strList){
			System.out.println(str);
		}
		
		
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("In child Thread");
			}
		});
		
		th.start();
		
		System.out.println("In Main thread");

	}
}

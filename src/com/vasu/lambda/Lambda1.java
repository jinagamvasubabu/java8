package com.vasu.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;;

public class Lambda1 {
	public static void main(String args[]) {
		FileFilter filter = (File file) -> file.getName().endsWith(".java"); //1st lambda
		
		
		Comparator<String> lambdaComp = (String o1, String o2) -> Integer.compare(o1.length(), o2.length());
		Comparator<Integer> simpleLambda = Integer::compare;
		
		File dir = new File("/Users/mac/Documents/workspace/Javaaa/Java8/src/com/vasu/lambda");
		File[] listFiles = dir.listFiles(filter);
		
		for(File f: listFiles){
			System.out.println(f.getName());
		}
		
		List<String> strList = Arrays.asList("***","**","****","*");
		Collections.sort(strList,lambdaComp);
		
		List<Integer> intList = Arrays.asList(1,42,2,190);
		Collections.sort(intList,simpleLambda);
		
		for(String str:strList){
			System.out.println(str);
		}
		
		for(Integer num:intList){
			System.out.println(num);
		}
		
		
		Thread th = new Thread(() -> System.out.println("In child Thread"));
		th.start();
		
		System.out.println("In Main Thread");
	}	
}	



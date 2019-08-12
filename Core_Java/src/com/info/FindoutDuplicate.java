package com.info;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindoutDuplicate {
	public static void main(String[] args) {
		List<String> subject = new ArrayList<>();
		subject.add("Spring");
		subject.add("Spring boot");
		subject.add("Hibernate");
		subject.add("Spring");
		subject.add("Hibernate");
		subject.add("Spring");
		subject.add("c++");
		subject.add("Servlet");

		System.out.println(subject);
		
List<String> response=forwardList(subject);
	System.out.println("Response List : "+response);
	}

	private static List<String> forwardList(List<String> subject) {
		List<String> duplicateElent=new ArrayList<>();
		Set<String> setlist=new HashSet<>();
		
		for(String str:subject) {
			if(!setlist.add(str)) {
				duplicateElent.add(str);
			}
			
		}
		
		return duplicateElent;
		
	}
}

package com.info;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_Demo {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(10);
		set.add(24);
		set.add(14);
		set.add(8);
		set.add(15);
		set.add(9);
		System.out.println(set);
		Iterator<Integer> iterator = set.iterator();
	
		while(iterator.hasNext()) {
			Integer next = iterator.next();
			System.out.println(next);
		}
	}
}

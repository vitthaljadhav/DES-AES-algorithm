package com.info;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IterateMap {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "java");
		map.put(3, "Spring");
		map.put(2, "hibernate");

		map.put(4, "C++");
		map.put(5, "python");
		map.put(6, "Net");
		map.put(7, "java");
		System.out.println(map);
		// 1st approach irtating map
		Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, String> next = iterator.next();
			System.out.println(next.getValue() + "    :   " + next.getValue());
		}

		// 2 approach iterating
		System.out.println("--------------------------Second Approach---------------------------------");
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for (Map.Entry<Integer, String> it : map.entrySet()) {
          String value = it.getValue();
		Integer key = it.getKey();
		System.out.println(key+"    :  "+value);
		}
		System.out.println("--------------------------Third Approach....");
		for (Integer key : map.keySet()) {
			System.out.println(key);
		}
		for (String value : map.values()) {
			System.out.println(value);
		}
		
		System.out.println("----------------------------4th approach---------------------");
		map.forEach((K,V)->System.out.println("Key :"+K+"  :  "+ V));
		
		
	}
}

package com.info;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

class Demo {
	private void dis() {
		System.out.println("this is private method");
	}
}

public class Demo_private {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		List<String> list1 = new ArrayList<>();
		list1.add("java");
		list1.add("Spring");
		list1.add("hibernate");
		list1.add("c");
		list1.add("Spring boot");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("java Duplicate");
		list2.add("Spring Duplicate");
		list2.add("hibernate Duplicate");
		list2.add("c Duplicate");
		list2.add("Spring boot Duplicate");

		List masterList = new ArrayList<>();
		masterList.add(list1);
		masterList.add(list2);
		System.out.println(masterList);
	}

}

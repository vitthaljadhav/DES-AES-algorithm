package com.info;

import java.util.Scanner;
public class Collection_Demo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Sum");
		int sum = scanner.nextInt();
		int a[] = { 1, 4, 7, 8, 2, 3, 6, 8 };
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j <= a.length - 1; j++) {
				if (a[i] + a[j] == sum) {
					System.out.println(a[i] + "," + a[j]);
				}
			}
		}
	}
}

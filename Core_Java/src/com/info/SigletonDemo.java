package com.info;

class Stud {
	private static Stud stud = null;

	private Stud() {
		System.out.println("New Instance...");
	}

	public static synchronized Stud getInstance() {
		if (stud == null) {
			stud = new Stud();
			return stud;
		}
		return null;
	}
}

public class SigletonDemo {
	public static void main(String[] args) {
		Runnable r1 = () -> {
			Stud.getInstance();
		};
		Runnable r2 = () -> {
			Stud.getInstance();
		};
		new Thread(r1).start();
		new Thread(r2).start();
	}
}

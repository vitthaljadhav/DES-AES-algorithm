package com.info;

public class SingletonDemoTest {

	private static SingletonDemoTest  test=null;
	
	private SingletonDemoTest() {
		System.out.println("New Instance..");
	}
	public static synchronized SingletonDemoTest getInstance() {
		if(test==null) {
			test=new SingletonDemoTest();
			return test;
		}
		return null;
	}
	
	public static void main(String[] args) {
	
		//this is one of Approach
		/*Runnable r1 = () -> {
			SingletonDemoTest.getInstance();
		};
		Runnable r2 = () -> {
			SingletonDemoTest.getInstance();
		};
		new Thread(r1).start();
		new Thread(r2).start();*/
	  //this is Second Approach
		Runnable r1=new Runnable() {
			@Override
			public void run() {
			SingletonDemoTest.getInstance();	
			}
		};
		
		Runnable r2=new Runnable() {
			@Override
			public void run() {
				SingletonDemoTest.getInstance();
			}			
		};
		new Thread(r1).start();
		new Thread(r2).start();
	}
}

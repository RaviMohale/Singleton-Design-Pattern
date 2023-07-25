package com.ravi.singleton;

import java.io.Serializable;

final public class SingletonClassExample extends Thread implements Serializable,Cloneable{
	
	//A
	//B extends A
	// A a = new B();
	
	
	// CLASS LOADER
	 //static SingletonClassExample s = new SingletonClassExample();// EAGER INITIALIAZATION
	 static SingletonClassExample s = null;  //lazy initialization

	
	 private SingletonClassExample() throws Exception  {
		// System.out.println("private constructor..!!!");
		
	}
	 
	 {
		 // instance initializer block in java
		 // the below instance code copy automatically in all the constructor
		 if(s != null) {
			 throw new Exception("Object Already present");
		 }
	 }
	 
		/*
		 * SingletonClassExample(int i) throws Exception{
		 * System.out.println("1 para contructor.!!!!"); }
		 */
	 
	static  SingletonClassExample  getInstace() throws Exception {
		// checking condition whether the object is already create or not ,if not create the object
		if(s == null) {
		 s = new SingletonClassExample();
	 }
		return s;
	}
	 
	 void m1() {
		 System.out.println("m1 instance method ");
	 }
	 
	 // we can fixed this by overriding readresolve() method for Singleton desing pattern in DeSerialization
	 Object readResolve() {
	 return s;
	 }
	 
	 @Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//return super.clone();   //it gives new object
		 return s;  // does not give new instance
	}
	 
	 @Override
	public void run() {
		 try {
	SingletonClassExample s6 = SingletonClassExample.getInstace();
	System.out.println(s6.hashCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

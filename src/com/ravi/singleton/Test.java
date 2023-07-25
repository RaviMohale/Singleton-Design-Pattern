package com.ravi.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		SingletonClassExample s = SingletonClassExample.getInstace();
		System.out.println(s.hashCode());
		
		SingletonClassExample s1 = SingletonClassExample.getInstace();
		System.out.println(s1.hashCode());
		
		/*
		 * SingletonClassExample s = new SingletonClassExample();
		 * System.out.println(s.hashCode());
		 * 
		 * SingletonClassExample s1 = new SingletonClassExample();
		 * System.out.println(s1.hashCode());
		 */
		
		// Reflection using reflection you can call private method,private constructor from outside of the class
		// De-serialization
		//Multi Threading 
		// Cloning
		
		
		// reflection
		
		/*
		 * Constructor<SingletonClassExample> s3 =
		 * SingletonClassExample.class.getDeclaredConstructor(); s3.setAccessible(true);
		 * SingletonClassExample obj = s3.newInstance();
		 * System.out.println(obj.hashCode());
		 */
	
	
	// De-serialization

	// serialization code
	//converting the object into series of byte and sending over the network
	
	FileOutputStream f = new FileOutputStream("C:\\Users\\Ravi\\Desktop\\serialize.txt");
	ObjectOutputStream out = new ObjectOutputStream(f);
	out.writeObject(s);
	
	// De-Serialization code

	FileInputStream f1 = new FileInputStream("C:\\Users\\Ravi\\Desktop\\serialize.txt");
	ObjectInputStream in = new ObjectInputStream(f1);
	SingletonClassExample s4=(SingletonClassExample)in.readObject();
	System.out.println(s4.hashCode());
	
	//  clone
	SingletonClassExample s5=(SingletonClassExample) s4.clone();
	System.out.println(s5.hashCode());
	
	
}
}

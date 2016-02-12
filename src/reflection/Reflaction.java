package reflection;

import java.util.HashSet;
import java.util.Set;

public class Reflaction {
	public static void main(String[] args){
		//get the class
		//1.if an instance of an object is available
		Class c = "foo".getClass();
		System.out.println(c);
		Set<String> s = new HashSet<>();
		Class c1 = s.getClass();
		System.out.println(c1);
		
		//2.if there is no instance
		boolean b;
		Class c2 = boolean.class;
		System.out.println(c2);
		System.out.println(java.lang.System.class);
		
		//3.Class.forName()
		Class c3;
		try {
			c3 = Class.forName("java.lang.String");
			System.out.println(c3);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4..Type
		Class c4 = Double.TYPE;
		System.out.println(c4);
		
		Class c5 = Void.TYPE;
		Class c6 = Void.class;
		System.out.println(c5);
		System.out.println(c6);
		
		//methods that return classes
		Class c7 = java.lang.String.class.getSuperclass();
		System.out.println(c7);
		
		try {
			Class c8 = System.class.getField("out").getDeclaringClass();
			System.out.println(c8);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

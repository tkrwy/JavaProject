package interview;

public class Outer {
	public void someOuterMethod(){
		new Inner();
	}
	public class Inner{
		
	}
	public static void main(String[] argv){
		Outer o = new Outer();
	}
}

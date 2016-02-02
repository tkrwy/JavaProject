package interview.String;

public class StringTest {
	public static void main(String[] args){
		//String str = "abc"，1.首先在常量痴中查找是否存在"abc"的字符串 2.如果不存在，则在常量池中创建"abc",并让str引用该对象 3.如果存在，则直接让str引用该对象
		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2);
		
		//String str = new String("abc") 1.先到常量池中查找是否已经存在"abc"的对象，如果没有则在常量池中创建一个此字符串对象，然后再堆中再创建一个常量池中此“abc”对象的拷贝对象
		String str3 = new String("abc");
		System.out.println(str1 == str3);
		
		//String.intern() 扩充常量池的一个方法，当一个String 实例str调用intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量，如果有，则返回其引用
		String str4 = str3.intern();
		System.out.println(str1 == str4);
		System.out.println(str3 == str4);
		
		String str5 = str1;
		System.out.println(str5);
		str1 = "efg";
		System.out.println("str5=" + str5);
		System.out.println("str1=" + str1);
		
		setName("a");
		setName("b");
		
	}
	
	public static void setName(final String name){
		System.out.println(name);
	}
}

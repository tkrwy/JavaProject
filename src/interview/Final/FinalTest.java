package interview.Final;

public class FinalTest {
	//final修饰类,说明类功能是完整的，不需要再被继承了
//	public final class Final1{
//		
//	};
//	public class Final2 extends Final1{
//		
//	}
	//final修饰方法，说明这个方法已经完整了，不需要再被重写
//	public class Final1{
//		public final String getName(){
//			return "Hello world";
//		}
//	};
//	public class Final2 extends Final1{
//		@Override
//		public final String getName(){
//			return "Hello world";
//		}
//	}
	//final修饰变量,不管是成员变量（类变量，实例变量），还是局部变量，行参
	//final可以和static一起修饰类变量，代表常量
	//public static final String NAME = "lulu";
	//final修饰成员变量，除了像上面一样可以在声明时初始化，还可以在静态块中初始化
	public static final String NAME;
	static{
		NAME = "HE";
	}
	//final修饰实例变量，可以在声明、构造器或非静态初始化块中初始化
//	public final String firstName = "ada";
	public final String firstName;
	{
		firstName = "ada";
	}
//	FinalTest(){
//		firstName = "ada";
//	}
}

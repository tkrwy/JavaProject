package jvm.executeOrder;
/** 
* @author 作者tkrwy: 
* @version 创建时间：2017年2月23日 下午3:15:24 
* 类说明 
*/
public class Child extends Parent{
	//静态块
	static {
		new Print("a");
	}
	//静态变量
	public static Print obj1 = new Print("b");
	//实例变量
	public Print obj2 = new Print("c");
	//构造函数
	public Child(){
		new Print("d");
	}
	//静态变量
	public static Print obj3 = new Print("e");
	//实例变量
	public Print obj4 = new Print("f");
	
	/**
	 * 执行顺序：
	 * 1.父类的静态变量和静态块，按照代码中出现的顺序执行
	 * 2.子类的静态变量和静态块
	 * 3.父类的实例变量
	 * 4.父类的构造函数
	 * 5.子类的实例变量
	 * 6.子类的构造函数
	 * 当类已经被加载，静态变量和静态块就不用重复执行，再创建类实例时，只执行与实例相关的变量初始化和构造方法
	 */
	public static void main(String[] args){
		Parent obj1 = new Child();
		Parent obj2 = new Child();
	}
	
	
}

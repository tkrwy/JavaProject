package jvm.executeOrder;
/** 
* @author 作者tkrwy: 
* @version 创建时间：2017年2月23日 下午3:15:13 
* 类说明 
*/
public class Parent {
	//静态变量
	public static Print obj1 = new Print("1");
	//实例变量
	public Print obj2 = new Print("2");
	//静态变量
	public static Print obj3 = new Print("3");
	//静态块
	static{
		new Print("4");
	}
	//实例变量
	public Print obj5 = new Print("5");
	//静态变量
	public static Print obj6 = new Print("6");
	//构造函数
	public Parent(){
		new Print("7");
	}
}

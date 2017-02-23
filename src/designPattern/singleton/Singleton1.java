package designPattern.singleton;
/** 
* @author 作者tkrwy: 
* @version 创建时间：2017年2月14日 下午2:38:02 
* 类说明  懒汉模式
*/
/**
 * 单例模式的七种写法：
 * 1.懒汉模式
 * 2.懒汉模式-线程安全
 * 3.饿汉模式-类加载机制
 * 4.饿汉模式-静态块
 * 5.静态内部类
 * 6.枚举类
 * 7.双重校验
 */
/**
 * 1.不能用new方法创建，那么构造方法必须是私有的
 * 2.通过一个静态方法获取
 * 3.定义一个实例变量，这个变量是静态的
 */
public class Singleton1 {
	private static Singleton1 singleton1;
	private Singleton1(){};
	public static Singleton1 getInstance(){
		if(singleton1 == null){
			singleton1 = new Singleton1();
		}
		return singleton1;
	}
	
	public static void main(String[] args){
		Singleton1 singleton1 = Singleton1.getInstance();
		System.out.println(singleton1);
	}
}

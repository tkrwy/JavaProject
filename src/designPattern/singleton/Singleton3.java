package designPattern.singleton;
/** 
* @author 作者tkrwy: 
* @version 创建时间：2017年2月14日 下午2:51:52 
* 类说明  饿汉模式
* 在类加载的时候初始化实例
* 原理：领用classloader机制避免了多线程同步的问题
* 缺点：没有lazy loading
*/
public class Singleton3 {
	private static Singleton3 singleton3 = new Singleton3();
	private Singleton3(){};
	public static Singleton3 getInstance(){
		return singleton3;
	}
}

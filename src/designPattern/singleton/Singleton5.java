package designPattern.singleton;
/** 
* @author 作者tkrwy: 
* @version 创建时间：2017年2月14日 下午3:08:26 
* 类说明  静态内部类。内部类的实例与外部类的实例没有绑定关系，而且只有被调用时才会被装载，从而实现了延迟加载
* 通过内部类实现延迟加载
*/
public class Singleton5 {
	private static class SingletonHolder{
		private static final Singleton5 instance = new Singleton5();
	}
	private Singleton5(){};
	public static final Singleton5 getInstance(){
		return SingletonHolder.instance;
	}
}

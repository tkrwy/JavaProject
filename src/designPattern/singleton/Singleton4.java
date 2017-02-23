package designPattern.singleton;
/** 
* @author 作者tkrwy: 
* @version 创建时间：2017年2月14日 下午3:00:48 
* 类说明  饿汉 通过静态块的方法初始化实例
*/
public class Singleton4 {
	private static Singleton4 instance = null;
	static{
		instance = new Singleton4();
	}
	private Singleton4(){};
	public Singleton4 getInstance(){
		return this.instance;
	}
}

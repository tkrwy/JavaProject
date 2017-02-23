package designPattern.singleton;
/** 
* @author 作者tkrwy: 
* @version 创建时间：2017年2月14日 下午2:48:13 
* 类说明 懒汉 线程安全
*/
public class Singleton2 {
	private static Singleton2 singleton2;
	private Singleton2(){};
	private static synchronized Singleton2 getInstance(){
		if(singleton2 == null){
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
}

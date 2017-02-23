package designPattern.singleton;
/** 
* @author 作者tkrwy: 
* @version 创建时间：2017年2月14日 下午3:47:52 
* 类说明  双重校验模式
*/
public class Singleton7 {
	private volatile static Singleton7 instance;
	private Singleton7(){};
	public static Singleton7 getInstance(){
		if(instance == null){
			synchronized(Singleton7.class){
				instance = new Singleton7();
			}
		}
		return instance;
	}
}

package exception;

/**
 * 
 * @author lulu
 *抛出异常有两种方式：1.当程序出现异常时，系统会自动抛出异常2.Java也允许程序员自行抛出异常，使用throw语句来完成
 */
public class ThrowTest {
/*
 * 如果throw语句抛出了Checked异常，则该throw语句要么处于try块中，要么放在一个带throws声明抛出的方法中
 */
	public static void main(String[] args){
		int a = 5;
		throwChecked1(a);
		try {
			throwChecked2(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//throwRuntime(a);
		try {
			bid("df");
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void throwChecked1(int a){
		if(a > 0){
			try {
				throw new Exception("a的值大于0，不符合要求！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void throwChecked2(int a) throws Exception{
		if(a > 0){
			throw new Exception("a的值大于0，不符合要求！");
		}
	}
	
	/*
	 * 如果抛出Runnable异常，即可以显式地捕获该异常，也可以不理会，把该异常交给该方法的调用者处理
	 */
	
	public static void throwRuntime(int a){
		if(a > 0){
			throw new RuntimeException("a的值大于0，不符合要求！ ");
		}
	}
	
	/*
	 * catch和throw同时使用
	 */
	public static void bid(String bidPrice) throws Exception{
		double d = 0.0;
		try{
			d = Double.parseDouble(bidPrice);
		}catch(Exception e){
			//e.printStackTrace();
			//throw new Exception("bidPrice输入不合法");
			throw new Exception(e);
		}
		
	}
}

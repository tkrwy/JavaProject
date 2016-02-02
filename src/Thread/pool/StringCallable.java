package Thread.pool;

import java.util.concurrent.Callable;

public class StringCallable implements Callable<String>{
	private int ticket = 10;
	
	@Override
	public String call() throws Exception {
		while(ticket > 0){
			ticket--;
			System.out.println(Thread.currentThread().getName() + "--->" + ticket);
		}
		return "Run";
	}

}

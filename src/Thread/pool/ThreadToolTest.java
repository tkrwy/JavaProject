package Thread.pool;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadToolTest {
	public static void main(String[] args){
		ExecutorService pool = Executors.newFixedThreadPool(4);
//		pool.submit(new StringCallable());
//		pool.submit(new StringCallable());
		//共享资源
//		StringCallable sc = new StringCallable();
//		pool.submit(sc);
//		pool.submit(sc);
//		pool.shutdown();
		
		//get the result of the task,利用CompletionService
		CompletionService<String> cpool = new ExecutorCompletionService<>(pool);
		cpool.submit(new StringCallable());
		cpool.submit(new StringCallable());
		
		for(int i = 0; i < 2;i++ ){
			try {
				String result = cpool.take().get();
				System.out.println(result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} 
		}
		
	}
}

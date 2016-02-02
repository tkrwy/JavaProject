package Thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinPoolTest {
	private static final int LENGTH = 100;
	public static void main(String[] args){
		int[] arr = new int[LENGTH];
		int total = 0;
		for(int i = 0; i<LENGTH;i++){
			arr[i] = i;
		}
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i<LENGTH;i++){
			total += arr[i];
		}
		long endTime = System.currentTimeMillis();
		System.out.println("计算Total为： " + total+".计算时间为" + (endTime - startTime));
		
		long startTime1 = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();
		Future<Integer> future = pool.submit(new CalTask(arr,0,arr.length));
		long endTime1 = System.currentTimeMillis();
		try {
			System.out.println("fork run运行时间为：" + future.get() + ".计算时间为" + (endTime1-startTime1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		pool.shutdown();
	}
}

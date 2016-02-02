package Thread;

public class SecondThread implements Runnable{
	private int i;
	@Override
	public void run() {
		for(; i < 10; i++){
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		
	}
	
	public static void main(String[] args){
		SecondThread st = new SecondThread();
		//共享线程类的实例属性
		new Thread(st).start();
		new Thread(st).start();
	}

}

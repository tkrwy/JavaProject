package Thread;

public class FirstThread extends Thread {
	private int i;
	
	@Override
	public void run(){
		for(;i<5;i++){
			System.out.println(getName() + ":" + i);
		}
	}
	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName());
		FirstThread ft1 = new FirstThread();
		ft1.setDaemon(true);
		System.out.println(ft1.isDaemon());
		ft1.start();
		
		FirstThread ft2 = new FirstThread();
		ft2.setDaemon(true);
		ft2.start();
		System.out.println(ft2.isDaemon());
	}
}

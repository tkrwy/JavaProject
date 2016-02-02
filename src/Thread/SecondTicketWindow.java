package Thread;

public class SecondTicketWindow implements Runnable{
	private int ticket = 10;

	@Override
	public void run() {
		while(ticket > 0){
			ticket--;
			System.out.println(Thread.currentThread().getName() + "----->" + ticket);
		}
		
	}
	
	public static void main(String[] args){
		//共享资源
//		SecondTicketWindow stw = new SecondTicketWindow();
//		Thread t1 = new Thread(stw);
//		Thread t2 = new Thread(stw);
//		Thread t3 = new Thread(stw);
//		t1.start();
//		t2.start();
//		t3.start();
		
		//没有共享资源
		SecondTicketWindow stw1 = new SecondTicketWindow();
		SecondTicketWindow stw2 = new SecondTicketWindow();
		SecondTicketWindow stw3 = new SecondTicketWindow();
		Thread t1 = new Thread(stw1);
		Thread t2 = new Thread(stw2);
		Thread t3 = new Thread(stw3);
		t1.start();
		t2.start();
		t3.start();
	}
	
}

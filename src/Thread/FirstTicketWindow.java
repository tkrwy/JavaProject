package Thread;

public class FirstTicketWindow extends Thread{
	private int ticket = 10;
	
	@Override
	public void run(){
		//当有一个人来时，卖出一张票,ticket - 1
		while(ticket > 0){
			ticket--;
			System.out.println(getName() + "------>" + ticket);
		}
	}
	
	public static void main(String[] args){
		FirstTicketWindow ftw = new FirstTicketWindow();
		FirstTicketWindow stw = new FirstTicketWindow();
		FirstTicketWindow ttw = new FirstTicketWindow();
		
		ftw.start();
		stw.start();
		ttw.start();
	}
}

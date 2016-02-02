package Thread.sync;

public class DrawThread extends Thread{
	private Account account;
	private double drawAmount;
	
	
	public DrawThread(String name,Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run(){
		//使用同步块
//		synchronized(account){
//			if(drawAmount <= account.getBalance()){
//				System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmount);
//				account.setBalance(account.getBalance() - drawAmount);
//				System.out.println("\t余额为： " + account.getBalance());
//			}else{
//				System.out.println(getName() + "取钱失败！余额不足！");
//			}
//		}
		
		//使用同步方法
		for(int i = 0; i < 10; i++){
			account.draw(drawAmount);
		}
				
	}
	
	public static void main(String[] args){
		Account account = new Account("111",0);
		//当有两个进程并发修改同一个文件时就有可能造成异常
		new DrawThread("取甲",account,800).start();
		new DrawThread("取乙",account,800).start();
		new DepositThread("存甲",account,800).start();
		//new DepositThread("存乙",account,800).start();
	}
}

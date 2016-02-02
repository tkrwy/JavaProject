package Thread.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import javax.management.Descriptor;

public class Account {
	private String accountNo;
	private double balance;
	//标识账户中是否有存款，若有存款，则可以取钱
	private boolean flag = false; 
	
	//定义锁对象
	private final ReentrantLock lock = new ReentrantLock();
	//使用Conndition进行线程通信
	private final Condition cond = lock.newCondition();
	public Account(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountNo == null) ? 0 : accountNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}
	
//	//使用同步方法
//	public synchronized void draw(double drawAmount){
//		if(drawAmount <= balance){
//			System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
//			balance -= drawAmount;
//			System.out.println("\t余额为： " + balance);
//		}else{
//			System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
//		}
//	}
	
	//使用同步锁（Lock）
//		public void draw(double drawAmount){
//			lock.lock();
//			try{
//				if(drawAmount <= balance){
//					System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
//					balance -= drawAmount;
//					System.out.println("\t余额为： " + balance);
//				}else{
//					System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
//				}
//			}finally{
//				lock.unlock();
//			}
//		}
		
		//线程通信，使用wait,nofify,nofifyAll
//		public synchronized void draw(double drawAmount){
//			
//			try{
//				//若无存款即等待
//				if(!flag){
//					wait();
//				}else{
//					System.out.println(Thread.currentThread().getName() + " 取钱成功！吐出钞票：" + drawAmount);
//					balance -= drawAmount;
//					System.out.println("\t余额为： " + balance);
//					flag = false;
//					notifyAll();
//				}
//				
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}finally{
//			}
//		}
//		
//		//存钱
//		public synchronized void deposit(double depositAmount){			
//				try {
//					if(flag){
//						wait();
//					}else{
//						System.out.println(Thread.currentThread().getName() + " 存款： " + depositAmount);
//						balance += depositAmount;
//						System.out.println("\t余额为： " + balance);
//						flag = true;
//						notifyAll();
//					}
//										
//				} catch (InterruptedException e) {
//					
//					e.printStackTrace();
//				}
//			
//			
//		}
		
		//线程通信，使用Condition的await,signal,signalAll
				public void draw(double drawAmount){
					lock.lock();
					try{
						//若无存款即等待
						if(!flag){
							cond.await();
						}else{
							System.out.println(Thread.currentThread().getName() + " 取钱成功！吐出钞票：" + drawAmount);
							balance -= drawAmount;
							System.out.println("\t余额为： " + balance);
							flag = false;
							cond.signalAll();
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally{
						lock.unlock();
					}
				}
				
				//存钱
				public synchronized void deposit(double depositAmount){			
					lock.lock();	
					try {
							if(flag){
								cond.await();
							}else{
								System.out.println(Thread.currentThread().getName() + " 存款： " + depositAmount);
								balance += depositAmount;
								System.out.println("\t余额为： " + balance);
								flag = true;
								cond.signalAll();
							}
												
						} catch (InterruptedException e) {							
							e.printStackTrace();
						} finally{
							lock.unlock();
						}
					
					
				}
		
}

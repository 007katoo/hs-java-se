package com.hongshao.thread;

public class SaleTicket {
	public static void main(String[] args) {
		SaleRunnable r = new SaleRunnable();
		Thread t1 = new Thread(r);
		t1.setName("zhangfei");
		Thread t2 = new Thread(r);
		t2.setName("guanyu");
		Thread t3 = new Thread(r);
		t3.setName("liubei");
		t1.start();
		t3.start();
		t2.start();
	}
}


class SaleRunnable implements Runnable {
	private int fiveAmount = 1;
	
	@Override
	public void run() {
		if(Thread.currentThread().getName()=="liubei" || Thread.currentThread().getName()=="guanyu") {
			sale(5);
		} else {
			sale(20);
		}
	}
	
	public synchronized void sale(int money) {
		if (money == 5) {
			fiveAmount = fiveAmount +1;
			System.out.println(Thread.currentThread().getName()+" buy success, the rest fiveAmount = "+fiveAmount);
		}else if (money == 20) {
				if (fiveAmount <3 ) {
					try {
						System.out.println("the rest fiveAmount is "+fiveAmount+"can't not charge, please wait ...");
//						使用Thread.currentThread().wait()会报错，而使用wait()不报错；
//						Thread.currentThread().wait();
						this.wait();
						System.out.println(Thread.currentThread().getName()+" continue to buy the key");
					} catch (InterruptedException e) {
					}
				}
				fiveAmount = fiveAmount -3;
				System.out.println(Thread.currentThread().getName()+" buy success, the rest fiveAmount = "+fiveAmount);
		}
//		Thread.currentThread().notifyAll();
		this.notify();
	}
	
	
}

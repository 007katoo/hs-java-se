package com.hongshao.thread.lock;

public class MyReentrantLockTest implements Runnable{
	
	MyReentrantLock rl = new MyReentrantLock();
	int no = 0;
	
	public void run() {
		rl.lock();
		for(int i=0;i<1000;i++) {
			no++;
			System.out.println(Thread.currentThread().getName()+": "+no);
		}
		rl.unlock();

	}
	
	public static void main(String[] args) {
		MyReentrantLockTest runable = new MyReentrantLockTest();
		Thread t1 = new Thread(runable,"t1");
		Thread t2 = new Thread(runable,"t2");
		Thread t3 = new Thread(runable,"t3");
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(runable.no);
	}
	
}

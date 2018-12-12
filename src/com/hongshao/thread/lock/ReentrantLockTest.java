package com.hongshao.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable{
	
	ReentrantLock rl = new ReentrantLock();
	int no = 0;
	
	@Override
	public void run() {
		
		rl.lock();
		for(int i=0;i<1000;i++) {
			no++;
			System.out.println(Thread.currentThread().getName()+": "+no);
		}
		rl.unlock();
		
	}
	
	public static void main(String[] args) {
		ReentrantLockTest runable = new ReentrantLockTest();
		Thread t1 = new Thread(runable,"t1");
		Thread t2 = new Thread(runable,"t2");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(runable.no);
	}
	
}

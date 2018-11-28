package com.hongshao.thread;

public class TakeApples {
	
	public static void main(String[] args) {
		TakenRunnable tr = new TakenRunnable();
		Thread t1 = new Thread(tr);
		Thread t2 = new Thread(tr);
		t1.start();
		t2.start();
	}
	
	
}

class TakenRunnable implements Runnable {
	
	private int count = 5;

	@Override
	public void run() {
		while(count>0) {
			count--;
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" taked appen, the left apples is "+ count);			
			
		}
	}
	
}

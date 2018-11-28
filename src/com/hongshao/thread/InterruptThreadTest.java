package com.hongshao.thread;

public class InterruptThreadTest extends Thread {
		
	@Override
	public void run() {
		
		for(int i =0;i<10;i++) {
			System.out.println(i);
		}
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		InterruptThreadTest t = new InterruptThreadTest();
		System.out.println(t.isAlive());
		t.start();
		System.out.println(t.isAlive());
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.isAlive());
	}
}

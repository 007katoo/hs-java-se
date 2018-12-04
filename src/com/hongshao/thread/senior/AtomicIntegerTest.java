package com.hongshao.thread.senior;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest extends Thread{
	
	private static AtomicInteger ai = new AtomicInteger(0);
//	private static int ai = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0;i<20000;i++) {			
			AtomicIntegerTest.ai.incrementAndGet();
//			ai++;
		}
	}
	
	public static void main(String[] args) {
		AtomicIntegerTest t1 = new AtomicIntegerTest();
		AtomicIntegerTest t2 = new AtomicIntegerTest();
		t1.start();
		t2.start();
		try {			
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
//		System.out.println(ai.get());
		System.out.println(ai);
		
	}

}

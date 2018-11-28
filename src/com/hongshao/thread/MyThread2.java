package com.hongshao.thread;

import java.util.concurrent.locks.LockSupport;

public class MyThread2 extends Thread{
	
	MyThread2(String s) {
		super(s);
	}
	
	@Override
	public void run() {
//		if (Thread.currentThread().getName()=="t2") {
//			LockSupport.park("wait until t1 end");
//		}
		for(int i =0;i<100;i++) {
			System.out.println(getName()+": "+ i);
			if(i%10==0) {
				Thread.yield();
			}
		}
	}
}

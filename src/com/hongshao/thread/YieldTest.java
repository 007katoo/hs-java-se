package com.hongshao.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * yield让一个running状态的线程转入runnable
 * @author Administrator
 *
 */
public class YieldTest {
	
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("t1");
		MyThread2 t2 = new MyThread2("t2");
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LockSupport.unpark(t2);
	}
}

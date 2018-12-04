package com.hongshao.thread;

/**
 * 多线程编程的意义
 * @author Administrator
 *
 */
public class TruthOfMultiThread implements Runnable {
	
	private static int count = 10;
	public synchronized void run() {
		while(count>0) {
			count--;			
			try {
				wait(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("in processing");
		}
	}
	
	
	public static void main(String[] args) {
//		singleThread();
		MultiThreadWithoutSynchronized();
//		MultiThreadWithSynchronized();
	}
	
	//10042 100times 100ms
	//20006 20times 1000ms
	public static void singleThread() {
		long begin = System.currentTimeMillis();
		for(int i=0;i<10;i++) {
			count--;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("in processing");
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin+","+count);
	}
	
	//5025 100times 100ms
	//10005 20times 1000ms
	public static void MultiThreadWithoutSynchronized() {
		long begin = System.currentTimeMillis();
		Runnable r = new TruthOfMultiThread();
		Thread t0 = new Thread(r);
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t0.start();
		t1.start();
		t2.start();
		try {
			t0.join();
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin+","+count);
	}
	
//	10046 100times 100ms
	//20011 100times 100ms
	public static void MultiThreadWithSynchronized() {
		long begin = System.currentTimeMillis();
		Runnable r = new TruthOfMultiThread();
		Thread t0 = new Thread(r);
		Thread t1 = new Thread(r);
		t0.start();
		t1.start();
		try {
			t0.join();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin+","+count);
	}
	
}

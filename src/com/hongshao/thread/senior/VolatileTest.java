package com.hongshao.thread.senior;

/**
 * volatile保证变量可见性，通过马上写入主存的方式
 * @author Administrator
 *
 */
public class VolatileTest implements Runnable{
	
	volatile Boolean running = false;
	int i =0;
	
	@Override
	public void run() {
		while(!running) {
			i = i +1;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		VolatileTest vt = new VolatileTest();
		Thread t = new Thread(vt);
		t.start();
		Thread.sleep(0);
		vt.running = true;
		Thread.sleep(1000);
		System.out.println(vt.i);
	}
}

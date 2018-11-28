package com.hongshao.thread;

/**
 * 普通同步方法，锁是当前实例对象
 * 静态同步方法，锁是当前类的class对象
 * 同步方法块，锁是括号里面的对象
 * @author Administrator
 *
 */
public class SynchronizedTest {
	public void method1() {
		System.out.println("Method 1 start");
		try {
			synchronized (this) {
				System.out.println("Method 1 execute");
				Thread.sleep(3000);				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 1 end");
	}

	public synchronized void method2() {
		System.out.println("Method 2 start");
		try {
			synchronized (this) {
				System.out.println("Method 2 execute");
				Thread.sleep(3000);	
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 2 end");
	}

	public static void main(String[] args) {
		final SynchronizedTest test = new SynchronizedTest();
		final SynchronizedTest test1 = new SynchronizedTest();

		new Thread(new Runnable() {
			@Override
			public void run() {
				test.method1();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				test.method2();
			}
		}).start();
	}
}
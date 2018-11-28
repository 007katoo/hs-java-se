package com.hongshao.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * jsp查看当前java进程，jstack查看当前进程栈
 * 
 * LockSupport.park( "Park" );设置当前线程阻塞；
 * 指明线程停止阻塞
 * LockSupport.unpark( (Thread) object );
 * @author Administrator
 *
 */
public class LockSupportTest {
	public static void main(String[] args) throws Exception {
		TestThread thread = new TestThread( Thread.currentThread() );
		thread.start();
		System.out.println( "before park" );
		// 等待获取许可
		LockSupport.park("test");
		System.out.println( "after park" );
		
//		TestThread thread = new TestThread();
//		thread.start();
//		try {
//			Thread.sleep( 1000 );
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}		
//		thread.interrupt();		
	}
}

class TestThread extends Thread {
	private Object object;
	public TestThread(Object object) {
		this.object = object;
	}
	public void run() {
		System.out.println( "before unpark" );
		// 休眠,保证setBlocker(t, blocker)
		try {
			Thread.sleep( 500 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 获取blocker
		System.out.println( "Blocker info: " + LockSupport.getBlocker( (Thread) object ) );
		// 释放许可
		LockSupport.unpark( (Thread) object );
		// 休眠500ms,保证先执行park中的setBlocker(t, null);
		try {
			Thread.sleep( 500 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println( "Blocker info: " + LockSupport.getBlocker( (Thread) object ) );
		System.out.println( "after unpark" );
	}
}

//class TestThread extends Thread {
//	public void run() {
//		System.out.println( Thread.currentThread().isInterrupted() );
//		LockSupport.park();
//		System.out.println( Thread.currentThread().isInterrupted() );
//	}
//}


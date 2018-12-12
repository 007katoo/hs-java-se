package com.hongshao.thread.interrupt;
/**
 * 1、对于阻塞线程，调用该线程的interrupt()方法，会让当前线程抛出异常，从而进入异常处理代码中，但不会中断程序
 * 2、非阻塞线程，调用线程的interrupt()方法，通过获取中断标志的方式判断是否结束当前线程；
 * @author hongshao
 * @date 2018-12-12
 * @githome https://github.com/007katoo/hs-java-se
 *
 */
public class InterruptTest {
	
//	public static void main(String[] args) {
//		Thread t1 = new Thread("t1"){
//			public void run() {
//				while(true) {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						System.out.println(this.getName()+" has been interrupted");
//						System.out.println(this.isInterrupted());
//						//清除中断标志位
//						System.out.println(Thread.interrupted());
//
//					}
//					System.out.println(this.getName()+" is continuing...");					
//				}
//			}
//		};
//		
//		t1.start();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		t1.interrupt();
//	}
//	
	public static void main(String[] args) {
		Thread t1 = new Thread("t1") {
			public void run() {
				while(!this.isInterrupted()) {
					System.out.println("t1 is running...");
				}
			};
		};
		
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}
}

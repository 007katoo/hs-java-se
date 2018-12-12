package com.hongshao.thread.interrupt;

/**
 * 线程阻塞可被interrupt打断到InterruptedException的异常处理中，跳出阻塞；
 * @author hongshao
 * @date 2018-12-12
 * @githome https://github.com/007katoo/hs-java-se
 *
 */
public class InterruptWaitThread {
	
	
	public static void main(String[] args) {
		
		Object obj = new Object();
		Thread t = new Thread("t") {
			
			public void run() {
				synchronized(obj) {
					try {
						System.out.println("test");
						obj.wait(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						
						System.out.println("thread t is interrupted");
					}
				}
			};
		};
		
		Thread t1 = new Thread("t1") {
			
			public void run() {
				synchronized(obj) {
					long begin = System.currentTimeMillis();
					while(System.currentTimeMillis() - begin<1000) {
						
					}
					System.out.println("t1");
				}
			};
		};
		t.start();
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.interrupt();
		System.out.println("main thread is done");
		
	}
}

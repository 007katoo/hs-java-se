package com.hongshao.thread;

import org.junit.Test;

/**
 * 
 * @author Administrator
 *
 */
public class JoinTest implements Runnable{  
    
    public static int a = 0;  
  
    public void run() {  
        for (int k = 0; k < 10; k++) {
        	try {
				Thread.currentThread().sleep(500);
				System.out.println("current thread: "+Thread.currentThread().getName()+" is sleeping and a is "+ a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            a = a + 1;
        }  
    }
    
    public static void main(String[] args) {
//		try {
//			new JoinTest().join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		new JoinTest().jointime();
	}

    @Test
    public void join() throws InterruptedException {
    	System.out.println("main thread begin");
        Runnable r = new JoinTest();  
        Thread t = new Thread(r);  
        t.start();
//        t.join();
        t.interrupt();
        System.out.println("main thread end");
    }
    
    @Test
    public void jointime() {
    	 Thread t = new Thread(new RunnableImpl());  
         t.start();
         try {  
             t.join(1000);  
             System.out.println("joinFinish");  
         } catch (InterruptedException e) {  
             e.printStackTrace();       
         }  
    }
}  
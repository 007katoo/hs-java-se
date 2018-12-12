package com.hongshao.thread.interrupt;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;


public class InterruptDesignTest {
	
 //	public static void main(String[] args) {
//		Thread t1 = new Thread("t1") {
//			public void run() {
//				while(!Thread.interrupted()) {
//					System.out.println("t1 is running...");
//				}
//			};
//		};
//		
//		t1.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		t1.interrupt();
//	}
	
	
	public static void main(String[] args) {
		 LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
		 System.out.println("thread test thread start");
		 TestThread testThread = new TestThread(queue);
		 testThread.start();
		 System.out.println("thread before interrupt");
		 testThread.interrupt();
		 queue.offer("after interrupt");
		 System.out.println("thread test thread interrupt");
	}
	
}

class TestThread extends Thread {
	LinkedBlockingQueue<String> queue;
	
	TestThread(LinkedBlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}
	
    private void A() {
      while(true) {
         B();
         if(this.isInterrupted()) {
        	 break;
         }
      }
   }

   private void B() {
	   try {
		   String value = queue.take();
		   System.out.println("thread take value:" + value);
	   } catch(InterruptedException e) {
		   this.interrupt();
	   }
   }

   @Override
   public void run() {
       super.run();
       A();
   }
 }



/**
 * 
 * @author hongshao
 * @date 2018-12-12
 * @githome https://github.com/007katoo/hs-java-se
 *
 */
class TestThreadThrowInterruptedException extends Thread {
	LinkedBlockingQueue<String> queue;
	
	TestThreadThrowInterruptedException(LinkedBlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}
	
    private void A() {
      while(true) {
          try {
        	  B();
          } catch(InterruptedException e) {
        	 break;
          }
      }
   }

   private void B() throws InterruptedException {
	   String value = queue.take();
	   System.out.println("thread take value:" + value);
   }

   @Override
   public void run() {
       super.run();
       A();
   }
 }


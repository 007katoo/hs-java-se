package com.hongshao.thread;

//Demo3.java的源码
class MyThread1 extends Thread {

 private volatile boolean flag= true;
 public void stopTask() {
     flag = false;
 }
 
 public MyThread1(String name) {
     super(name);
 }

 @Override
 public void run() {
     synchronized(this) {
         try {
             int i=0;
             while (flag) {
                 Thread.sleep(100); // 休眠100ms
                 i++;
                 System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);  
             }
         } catch (InterruptedException ie) {  
             System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");  
         }
     }  
 }
}

public class InterruptedFlag {

 public static void main(String[] args) {  
     try {  
         MyThread1 t1 = new MyThread1("t1");  // 新建“线程t1”
         System.out.println(t1.getName() +" ("+t1.getState()+") is new.");  

         t1.start();                      // 启动“线程t1”
         System.out.println(t1.getName() +" ("+t1.getState()+") is started.");  

         // 主线程休眠300ms，然后主线程给t1发“中断”指令。
         Thread.sleep(300);
         System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");
         t1.stopTask();

         // 主线程休眠300ms，然后查看t1的状态。
         Thread.sleep(300);
         System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
     } catch (InterruptedException e) {  
         e.printStackTrace();
     }
 } 
}
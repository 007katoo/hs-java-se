package com.hongshao.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockInterruptTest{

    public static void main(String[] args) {
    	MyReentrantLock r1 = new MyReentrantLock();
    	MyReentrantLock r2 = new MyReentrantLock();
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    r1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+" get the control of lock1");
                    sleep(2000);
                    r2.lock();
                    r1.unlock();
                    r2.unlock();
                } catch (InterruptedException e) {
                    r1.unlock();
                    System.out.println("线程t1释放了锁lock1");
                }
            }
        };
        t1.start();

        new Thread("t2") {
            @Override
            public void run() {
                try {
                    r2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+" get the control of lock2");
                    sleep(2000);
                    r1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName()+" get the control of lock1");
                    r1.unlock();
                    r2.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main线程中断t1线程");
        t1.interrupt();
    }
}

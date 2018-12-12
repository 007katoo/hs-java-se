package com.hongshao.thread;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest2 {

    RunnableImpl r = new RunnableImpl();
    Thread t1 = new Thread(r,"t1");

//    @Test
//    public void testPark() {
//        t1.start();
//        LockSupport.park("delay for 2s");
//        System.out.println("end main thread");
//    }

    public static void main(String[] args) throws Exception {

        Thread currThread = Thread.currentThread();
        new Thread(()->{
            try {
                Thread.sleep(3000);
                currThread.interrupt();
                //unsafe.unpark(currThread);
            } catch (Exception e) {}
        }).start();

        LockSupport.parkUntil(false, 0);

        System.out.println("SUCCESS!!!");
    }
}


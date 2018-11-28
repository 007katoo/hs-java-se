package com.hongshao.thread;

public class ThreadTest {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.setName("thread-1");
        Thread thread1 = new Thread(myRunnable);
        thread1.setName("thread-2");
        try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName() + " " + i);
//            if (i == 30) {
//                try {
//					thread.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				thread1.start();
//            }
////            if(i == 40){
////                myRunnable.stopThread();
////            }
//        }
    }
}

class MyRunnable implements Runnable {

    private boolean stop = false;

    @Override
    public void run() {
        for (int i = 0; i < 100 && !stop; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public void stopThread() {
        this.stop = true;
    }

}
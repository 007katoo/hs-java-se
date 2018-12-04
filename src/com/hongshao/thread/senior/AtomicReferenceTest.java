package com.hongshao.thread.senior;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest extends Thread{
	
	private static Book b = new Book();
	
	AtomicReference<Book> ar = new AtomicReference<Book>(b);
	
	@Override
	public void run() {
		for(int i=0;i<10000;i++) {
			AtomicReferenceTest.b.setRead_count(AtomicReferenceTest.b.getRead_count()+1);
			ar.getAndSet(AtomicReferenceTest.b);			
		}
	}
	
	public static void main(String[] args) {
		AtomicReferenceTest t1 = new AtomicReferenceTest();
		AtomicReferenceTest t2 = new AtomicReferenceTest();
		t1.start();
		t2.start();
		try {			
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(b.getRead_count());
		
	}
	
	private static class Book{
		private int read_count = 0;

		public int getRead_count() {
			return read_count;
		}

		public void setRead_count(int read_count) {
			this.read_count = read_count;
		}
		
	}	
	
}

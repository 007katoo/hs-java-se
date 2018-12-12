package com.hongshao.thread.senior;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

class UnsafeClass {
	
	private static final Unsafe unsafe = getUnsafe();
	private static final long stateOffset;
    private volatile int state = 0;
	 static {
	        try {
	            stateOffset = unsafe.objectFieldOffset
	                (UnsafeClass.class.getDeclaredField("state"));

	        } catch (Exception ex) { throw new Error(ex); }
	    }
	 
    /**
     * CAS head field. Used only by enq.
     */
    final boolean compareAndSetSate(int expect, int update) {
    	 return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }
    
    protected final int getState() {
        return state;
    }

    /**
     * Sets the value of synchronization state.
     * This operation has memory semantics of a {@code volatile} write.
     * @param newState the new state value
     */
    protected final void setState(int newState) {
        state = newState;
    }
    
    public static Unsafe getUnsafe() {
    	   try {
    	           Field f = Unsafe.class.getDeclaredField("theUnsafe");
    	           f.setAccessible(true);
    	           return (Unsafe)f.get(null);
    	   } catch (Exception e) { 
    	       /* ... */
    	   }
		return null;
    	}
	
}

public class UnsafeTest {
	
	
	public static void main(String[] args) {
		UnsafeClass obj = new UnsafeClass();
		obj.compareAndSetSate(0,5);
		System.out.println(obj.getState());
	}
}

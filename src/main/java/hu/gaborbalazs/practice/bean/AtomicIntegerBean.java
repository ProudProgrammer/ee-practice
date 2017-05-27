package hu.gaborbalazs.practice.bean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author gaborb
 *
 */
public class AtomicIntegerBean {
	
	private AtomicInteger atomicInt = new AtomicInteger();
	
	public int addAndGetInt(int n) {
		return atomicInt.addAndGet(n);
	}
	
	public int getInt() {
		return atomicInt.get();
	}
}

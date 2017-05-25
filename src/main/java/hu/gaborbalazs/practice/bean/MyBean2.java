package hu.gaborbalazs.practice.bean;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * 
 * @author gaborb
 *
 */
@Dependent
public class MyBean2 {
	
	private AtomicInteger atomicInt = new AtomicInteger();
	
	public int addAndGetInt(int n) {
		return atomicInt.addAndGet(n);
	}
	
	public int getInt() {
		return atomicInt.get();
	}
}

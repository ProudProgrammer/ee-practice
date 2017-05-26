package hu.gaborbalazs.practice.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jboss.logging.Logger;

/**
 * 
 * @author gaborb
 *
 */
@Dependent
public class DependentBean {

	@Inject
	Logger logger;
	
	private int value;
	
	public void increaseValue() {
		value++;
	}
	public int getValue() {
		return value;
	}
	
	@PostConstruct
	private void postConstruct() {
		logger.info("@PostConstruct - DependentBean");
	}
	
	@PreDestroy
	private void preDestroy() {
		logger.info("@PreDestroy - DependentBean");
	}
}

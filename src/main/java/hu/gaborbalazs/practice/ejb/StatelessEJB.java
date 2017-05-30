package hu.gaborbalazs.practice.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;

@Stateless
public class StatelessEJB {

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
		logger.info("@PostConstruct - " + getClass().getSimpleName());
	}
	
	@PreDestroy
	private void preDestroy() {
		logger.info("@PreDestroy - " + getClass().getSimpleName());
	}
}

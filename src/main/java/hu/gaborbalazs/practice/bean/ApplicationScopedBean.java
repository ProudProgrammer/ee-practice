package hu.gaborbalazs.practice.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

@ApplicationScoped
public class ApplicationScopedBean {

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

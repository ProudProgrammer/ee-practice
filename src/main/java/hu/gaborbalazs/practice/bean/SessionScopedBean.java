package hu.gaborbalazs.practice.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

@SessionScoped
public class SessionScopedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

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

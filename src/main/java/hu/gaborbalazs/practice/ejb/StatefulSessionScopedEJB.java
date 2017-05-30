package hu.gaborbalazs.practice.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

/**
 * 
 * @author gaborb
 *
 */
@Stateful
//@StatefulTimeout(value = 5, unit = TimeUnit.SECONDS)
@SessionScoped
public class StatefulSessionScopedEJB {
	
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

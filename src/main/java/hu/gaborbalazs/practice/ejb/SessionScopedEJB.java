package hu.gaborbalazs.practice.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

import org.jboss.logging.Logger;

/**
 * 
 * @author gaborb
 *
 */
@Stateful
@SessionScoped
public class SessionScopedEJB {
	
	Logger logger = Logger.getLogger(SessionScopedEJB.class);
	
	private int value;
	
	public void increaseValue() {
		value++;
	}
	public int getValue() {
		return value;
	}
	
	@PostConstruct
	private void postConstruct() {
		logger.info("@PostConstruct - SessionScopedEJB");
	}
	
	@PreDestroy
	private void preDestroy() {
		logger.info("@PreDestroy - SessionScopedEJB");
	}
}

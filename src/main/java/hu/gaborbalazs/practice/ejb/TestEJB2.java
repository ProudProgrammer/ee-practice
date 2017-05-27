package hu.gaborbalazs.practice.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.inject.Inject;

import org.jboss.logging.Logger;

/**
 * 
 * @author gaborb
 *
 */
@Stateful
public class TestEJB2 {

	@Inject
	Logger logger;
	
	private String welcome = "Hello World";
	
	public String getWelcome() {
		return welcome;
	}
	
	@PostConstruct
	private void postConstruct() {
		logger.info("@PostConstruct - TestEJB");
	}
}
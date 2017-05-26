package hu.gaborbalazs.practice.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;

/**
 * 
 * @author gaborb
 *
 */
@Stateless
public class TestEJB {

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

package hu.gaborbalazs.practice.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

/**
 * 
 * @author gaborb
 *
 */
@Stateless
public class TestEJB {

	Logger logger = Logger.getLogger(TestEJB.class);
	
	private String welcome = "Hello World";
	
	public String getWelcome() {
		return welcome;
	}
	
	@PostConstruct
	private void postConstruct() {
		logger.info("@PostConstruct - TestEJB");
	}
}

package hu.gaborbalazs.practice.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

/**
 * 
 * @author gaborb
 *
 */
@Stateful
@ApplicationScoped
public class TestEJB2 {

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
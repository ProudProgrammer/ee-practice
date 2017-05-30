package hu.gaborbalazs.practice.cdi;

import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

@ApplicationScoped
public class CDIProducer {

	@Produces
	@PersistenceContext(unitName = "testPU")
	private EntityManager em;
	
	@Produces
	private String producedMessage = "Welcome :)";
	
	@Produces
	private Logger createLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	
	@Produces
	private double randomNumber() {
		return ThreadLocalRandom.current().nextDouble(1, 1000);
	}
}

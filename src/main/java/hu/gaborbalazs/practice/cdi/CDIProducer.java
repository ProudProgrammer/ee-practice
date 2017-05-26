package hu.gaborbalazs.practice.cdi;

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
	private String welcomeMessage = "Welcome :)";
	
	@Produces
	private Logger createLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}

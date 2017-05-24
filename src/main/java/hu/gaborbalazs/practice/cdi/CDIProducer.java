package hu.gaborbalazs.practice.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class CDIProducer {

	@Produces
	@PersistenceContext(unitName = "testPU")
	private EntityManager em;
}

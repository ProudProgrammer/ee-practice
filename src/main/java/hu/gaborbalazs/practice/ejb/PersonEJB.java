package hu.gaborbalazs.practice.ejb;

import java.text.MessageFormat;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.entity.Person;

@Stateless
public class PersonEJB {

	@Inject
	Logger logger;

    @Inject
    private EntityManager em;
    
    public void createPerson(Person person) {
    	logger.info(MessageFormat.format(">> createPerson({0})", person));

        em.merge(person);
        em.flush();
        
        logger.info(MessageFormat.format("<< createPerson({0})", person));
    }
}

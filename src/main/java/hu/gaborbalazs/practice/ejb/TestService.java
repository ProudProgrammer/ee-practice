package hu.gaborbalazs.practice.ejb;

import java.text.MessageFormat;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import hu.gaborbalazs.practice.entity.TestEntity;

/**
 * 
 * @author gaborb
 *
 */
@Stateless
public class TestService {
	
	Logger logger = Logger.getLogger(TestService.class);

    @Inject
    private EntityManager em;

    public void saveNewEntity() {
    	logger.info(">> saveNewEntity()");

        TestEntity testEntity = new TestEntity();
        testEntity.setValue("mytest");

        em.persist(testEntity);
        
        logger.info("<< saveNewEntity()");
    }

    public List<TestEntity> getAllEntities() {
    	logger.info(">> getAllEntities()");
    	
    	List<TestEntity> entities = em.createQuery("SELECT _testEntity FROM TestEntity _testEntity", TestEntity.class)
                .getResultList();;
    	
    	logger.info(MessageFormat.format("<< getAllEntities(): [{0}]", entities));
    	
        return entities;
    }
    
    public int nativeQueryTest() {
    	logger.info(">> nativeQueryTest()");
    	
    	Query query = em.createNativeQuery("SELECT * FROM test_native");
    	int rows = query.getResultList().size();
    	
    	logger.info(MessageFormat.format("<< nativeQueryTest(): [{0}]", rows));
    	
    	return rows;
    }

}

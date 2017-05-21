package hu.gaborbalazs.practice.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hu.gaborbalazs.practice.entity.TestEntity;

/**
 * This service does some JPA operations. The purpose of this entire test
 * is just to see whether the data source can be used so the actual operations
 * don't matter much.
 * 
 * @author Arjan Tijms
 *
 */
@Stateless
public class TestService {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveNewEntity() {

        TestEntity testEntity = new TestEntity();
        testEntity.setValue("mytest");

        entityManager.persist(testEntity);
    }

    public List<TestEntity> getAllEntities() {
        return entityManager.createQuery("SELECT _testEntity FROM TestEntity _testEntity", TestEntity.class)
            .getResultList();
    }

}

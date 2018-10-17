package pl.javastart.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.javastart.model.Person;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class PersonRepository {

    private EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void add(Person person) {
        entityManager.persist(person);
    }
}

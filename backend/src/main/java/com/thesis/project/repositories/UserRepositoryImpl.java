package com.thesis.project.repositories;

import com.thesis.project.model.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Person findByUsername(String username) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Person.class);
        crit.add(Restrictions.eq("username", username));
        return (Person) crit.uniqueResult();
    }

    @Override
    public Person findById(Long id) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Person.class);
        crit.add(Restrictions.eq("id", id));
        return (Person) crit.uniqueResult();
    }

    @Override
    public ArrayList<Person> findAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(Person.class).list());
    }

    @Override
    public void update(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(person);
    }

    @Override
    public void save(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.save(person);
        session.flush();
    }

    @Override
    public void delete(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.delete(person);
    }


}

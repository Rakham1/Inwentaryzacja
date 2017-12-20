package com.thesis.project.repositories;

import com.thesis.project.model.Firm;
import com.thesis.project.model.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;

@Repository
public class FirmRepositoryImpl implements FirmRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Firm findByFirmId(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Firm.class);
        crit.add(Restrictions.eq("id", id));
        return (Firm) crit.uniqueResult();
    }

    @Override
    public Firm findFirmByUserId(Long userId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Firm.class);
        Person person = session.load(Person.class, userId);
        Firm firm = person.getFirm();
        return firm;
    }

    @Override
    public ArrayList<Firm> getAllFirms() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(Firm.class).list());
    }

    @Override
    public void update(Firm firm) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(firm);
    }

    @Override
    public void save(Firm firm) {
        Session session = entityManager.unwrap(Session.class);
        session.save(firm);
        session.flush();
    }
}

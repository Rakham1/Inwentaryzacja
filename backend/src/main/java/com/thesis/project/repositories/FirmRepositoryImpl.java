package com.thesis.project.repositories;

import com.thesis.project.model.Firm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class FirmRepositoryImpl implements FirmRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Firm findByFirmId(long id) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Firm.class);
        crit.add(Restrictions.eq("id",id));
        return (Firm) crit.uniqueResult();
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

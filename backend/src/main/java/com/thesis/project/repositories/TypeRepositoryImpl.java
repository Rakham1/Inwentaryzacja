package com.thesis.project.repositories;

import com.thesis.project.model.Type;
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
public class TypeRepositoryImpl implements TypeRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Type findTypeById(Long id) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Type.class);
        crit.add(Restrictions.eq("id", id));
        return (Type) crit.uniqueResult();
    }

    @Override
    public Type findTypeByName(String name) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Type.class);
        crit.add(Restrictions.eq("name", name));
        return (Type) crit.uniqueResult();
    }

    @Override
    public ArrayList<Type> findAllTypes() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(Type.class).list());
    }

    @Override
    public void update(Type type) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(type);
    }

    @Override
    public void save(Type type) {
        Session session = entityManager.unwrap(Session.class);
        session.save(type);
        session.flush();
    }

    @Override
    public void delete(Type type) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.delete(type);
    }
}

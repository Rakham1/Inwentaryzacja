package com.thesis.project.repositories;

import com.thesis.project.model.Group;
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
public class GroupRepositoryImpl implements GroupRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Group findGroupById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Group.class);
        crit.add(Restrictions.eq("id", id));
        return (Group) crit.uniqueResult();
    }

    @Override
    public Group findGroupByName(String name) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Group.class);
        crit.add(Restrictions.eq("name", name));
        return (Group) crit.uniqueResult();
    }

    @Override
    public ArrayList<Group> findAllGroups() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(Group.class).list());
    }

    @Override
    public void update(Group group) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(group);
    }

    @Override
    public void save(Group group) {
        Session session = entityManager.unwrap(Session.class);
        session.save(group);
        session.flush();
    }

    @Override
    public void delete(Group group) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.delete(group);
    }
}

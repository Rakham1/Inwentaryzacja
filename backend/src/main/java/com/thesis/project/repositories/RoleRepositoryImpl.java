package com.thesis.project.repositories;

import com.thesis.project.model.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Role findRoleByName(String name) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Role.class);
        crit.add(Restrictions.eq("name", name));
        return (Role) crit.uniqueResult();
    }

    @Override
    public ArrayList<Role> findAllRoles() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(Role.class).list());
    }
}

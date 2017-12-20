package com.thesis.project.repositories;

import com.thesis.project.model.Inventory;
import com.thesis.project.model.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Set;

@Repository
@Transactional
public class InventoryRepositoryImpl implements InventoryRepository {
    @Autowired
    private EntityManager entityManager;
    @Override
    public Inventory findByInvId(Long id) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Inventory.class);
        crit.add(Restrictions.eq("id", id));
        return (Inventory) crit.uniqueResult();
    }

    @Override
    public ArrayList<Inventory> findAllInvsByUserId(Long personId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Inventory.class);
        Person person = session.load(Person.class, personId);
        Set<Inventory> inventories = person.getInventory();
        return new ArrayList<>(inventories);
    }

    @Override
    public ArrayList<Inventory> getAllInvs() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(Inventory.class).list());
    }

    @Override
    public Long save(Inventory inventory) {
        Session session = entityManager.unwrap(Session.class);
        Long id = (Long) session.save(inventory);
        session.flush();
        return id;
    }

    @Override
    public void update(Inventory inventory) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(inventory);
    }

    @Override
    public void delete(Inventory inventory) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.delete(inventory);
    }
}

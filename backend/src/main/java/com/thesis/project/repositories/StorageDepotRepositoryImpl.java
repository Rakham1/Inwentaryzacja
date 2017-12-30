package com.thesis.project.repositories;

import com.thesis.project.model.Person;
import com.thesis.project.model.StorageDepot;
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
public class StorageDepotRepositoryImpl implements StorageDepotRepository {
    @Autowired
    private EntityManager entityManager;
    @Override
    public StorageDepot findByDepId(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(StorageDepot.class);
        crit.add(Restrictions.eq("id", id));
        return (StorageDepot) crit.uniqueResult();
    }

    @Override
    public ArrayList<StorageDepot> findAllDepotsByUserId(Long personId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(StorageDepot.class);
        Person person = session.load(Person.class, personId);
        Set<StorageDepot> storageDepots = person.getStorageDepots();
        return new ArrayList<>(storageDepots);
    }

    @Override
    public ArrayList<StorageDepot> getAllDepots() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(StorageDepot.class).list());
    }

    @Override
    public Long save(StorageDepot storageDepot) {
        Session session = entityManager.unwrap(Session.class);
        Long id = (Long) session.save(storageDepot);
        session.flush();
        return id;
    }

    @Override
    public void update(StorageDepot storageDepot) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(storageDepot);
    }

    @Override
    public void delete(StorageDepot storageDepot) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.delete(storageDepot);
    }
}

package com.thesis.project.repositories;

import com.thesis.project.model.Firm;
import com.thesis.project.model.Person;
import com.thesis.project.model.Warehouse;
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
public class WarehouseRepositoryImpl implements WarehouseRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Warehouse findByWhId(Long id) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Warehouse.class);
        crit.add(Restrictions.eq("id", id));
        return (Warehouse) crit.uniqueResult();
    }

    @Override
    public ArrayList<Warehouse> findAllWhs() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(Warehouse.class).list());
    }

    @Override
    public ArrayList<Warehouse> getWhsByFirmId(Long firmId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Warehouse.class);
        Firm firm = session.load(Firm.class, firmId);
        Set<Warehouse> warehouses = firm.getWarehouse();
        return new ArrayList<>(warehouses);
    }

    @Override
    public void update(Warehouse warehouse) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(warehouse);
    }

    @Override
    public void save(Warehouse warehouse) {
        Session session = entityManager.unwrap(Session.class);
        session.save(warehouse);
        session.flush();
    }

    @Override
    public void delete(Warehouse warehouse) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.delete(warehouse);
    }
}

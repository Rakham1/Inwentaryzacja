package com.thesis.project.repositories;

import com.thesis.project.model.WarIt;
import com.thesis.project.model.Warehouse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class WarehouseItemRepositoryImpl implements WarehouseItemRepository {
    @Autowired
    EntityManager entityManager;
    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public ArrayList<WarIt> getWhItemsByWhId(Long warehouseId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(WarIt.class);
        Warehouse warehouse = session.load(Warehouse.class, warehouseId);
        Set<WarIt> warIts = warehouse.getWarIts();
        return new ArrayList<>(warIts);
    }

    @Override
    public void save(WarIt warIt) {
        Session session = entityManager.unwrap(Session.class);
        session.save(warIt);
        session.flush();
    }
}

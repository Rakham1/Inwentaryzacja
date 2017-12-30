package com.thesis.project.repositories;

import com.thesis.project.model.DepIt;
import com.thesis.project.model.StorageDepot;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Set;

@Repository
@Transactional
public class DepItRepositoryImpl implements DepItRepository {
    @Autowired
    EntityManager entityManager;
    @Override
    public ArrayList<DepIt> getItemsByDepId(Long depotId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(DepIt.class);
        StorageDepot storageDepot = session.load(StorageDepot.class, depotId);
        Set<DepIt> depIts = storageDepot.getDepIt();
        return new ArrayList<>(depIts);
    }

    @Override
    public void save(DepIt depIt) {
        Session session = entityManager.unwrap(Session.class);
        session.save(depIt);
        session.flush();
    }
}

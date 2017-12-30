package com.thesis.project.repositories;

import com.thesis.project.model.Contractor;
import com.thesis.project.model.Firm;
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
public class ContractorRepositoryImpl implements ContractorRepository {
    @Autowired
    EntityManager entityManager;
    @Override
    public Contractor findByContractorId(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Contractor.class);
        crit.add(Restrictions.eq("id", id));
        return (Contractor) crit.uniqueResult();
    }

    @Override
    public Contractor findContractorByStorageDepId(Long storageDepId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Contractor.class);
        StorageDepot storageDepot = session.load(StorageDepot.class, storageDepId);
        Contractor contractor = storageDepot.getContractor();
        return contractor;
    }

    @Override
    public ArrayList<Contractor> getAllContractorsByFirmId(Long firmId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Contractor.class);
        Firm firm = session.load(Firm.class, firmId);
        Set<Contractor> contractors = firm.getContractors();
        return new ArrayList<>(contractors);
    }

    @Override
    public ArrayList<Contractor> getAllContractors() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(Contractor.class).list());
    }

    @Override
    public void update(Contractor contractor) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(contractor);
    }

    @Override
    public void save(Contractor contractor) {
        Session session = entityManager.unwrap(Session.class);
        session.save(contractor);
        session.flush();
    }
}
package com.thesis.project.repositories;

import com.thesis.project.model.ItemRelease;
import com.thesis.project.model.RelIt;
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
public class ReleaseItRepositoryImpl implements ReleaseItRepository {
    @Autowired
    EntityManager entityManager;
    @Override
    public ArrayList<RelIt> getItemsByRelId(Long releaseId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(RelIt.class);
        ItemRelease itemRelease = session.load(ItemRelease.class, releaseId);
        Set<RelIt> invItes = itemRelease.getRelIts();
        return new ArrayList<>(invItes);
    }

    @Override
    public void save(RelIt relIt) {
        Session session = entityManager.unwrap(Session.class);
        session.save(relIt);
        session.flush();
    }
}

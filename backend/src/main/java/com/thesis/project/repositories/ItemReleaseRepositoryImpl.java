package com.thesis.project.repositories;

import com.thesis.project.model.ItemRelease;
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
public class ItemReleaseRepositoryImpl implements ItemReleaseRepository {
    @Autowired
    private EntityManager entityManager;
    @Override
    public ItemRelease findByIRelId(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(ItemRelease.class);
        crit.add(Restrictions.eq("id", id));
        return (ItemRelease) crit.uniqueResult();
    }

    @Override
    public ArrayList<ItemRelease> findAllIRelsByUserId(Long personId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(ItemRelease.class);
        Person person = session.load(Person.class, personId);
        Set<ItemRelease> itemReleases = person.getItemReleases();
        return new ArrayList<>(itemReleases);
    }

    @Override
    public ArrayList<ItemRelease> getAllIRels() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(ItemRelease.class).list());
    }

    @Override
    public Long save(ItemRelease itemRelease) {
        Session session = entityManager.unwrap(Session.class);
        Long id = (Long) session.save(itemRelease);
        session.flush();
        return id;
    }

    @Override
    public void update(ItemRelease itemRelease) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(itemRelease);
    }

    @Override
    public void delete(ItemRelease itemRelease) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.delete(itemRelease);
    }
}

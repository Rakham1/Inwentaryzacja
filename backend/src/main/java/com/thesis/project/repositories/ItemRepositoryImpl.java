package com.thesis.project.repositories;

import com.thesis.project.model.Item;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Item findProductById(Long id) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Item.class);
        crit.add(Restrictions.eq("id", id));
        return (Item) crit.uniqueResult();
    }

    @Override
    public Item findProductByName(String name) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Item.class);
        crit.add(Restrictions.eq("itemName", name));
        return (Item) crit.uniqueResult();
    }

    @Override
    public ArrayList<Item> findAllProducts() {
        Session session = entityManager.unwrap(Session.class);
        return new ArrayList(session.createCriteria(Item.class).list());
    }

    @Override
    public ArrayList<Item> search(String itemName) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Item.class);
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        crit.add(Restrictions.like("itemName", "%" + itemName + "%").ignoreCase());
        return new ArrayList(crit.list());
    }

    @Override
    public Item getItemByBarcode(String text) {
        Session session = entityManager.unwrap(Session.class);

        Criteria crit = session.createCriteria(Item.class);
        crit.add(Restrictions.eq("barcode", text));
        return (Item) crit.uniqueResult();
    }

    @Override
    public void update(Item item) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(item);
    }

    @Override
    public Long save(Item item) {
        Session session = entityManager.unwrap(Session.class);
        Long id = (Long) session.save(item);
        session.flush();
        return id;
    }

    @Override
    public void delete(Item item) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.delete(item);
    }
}
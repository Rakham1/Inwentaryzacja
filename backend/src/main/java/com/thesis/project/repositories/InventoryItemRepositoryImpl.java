package com.thesis.project.repositories;

import com.thesis.project.model.InvIte;
import com.thesis.project.model.Inventory;
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
public class InventoryItemRepositoryImpl implements InventoryItemRepository {
    @Autowired
    EntityManager entityManager;
    @Override
    public ArrayList<InvIte> getItemsByInvId(Long inventoryId) {
        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(InvIte.class);
        Inventory inventory = session.load(Inventory.class, inventoryId);
        Set<InvIte> invItes = inventory.getInvItes();
        return new ArrayList<>(invItes);
    }

    @Override
    public void save(InvIte invIte) {
        Session session = entityManager.unwrap(Session.class);
        session.save(invIte);
        session.flush();
    }
}

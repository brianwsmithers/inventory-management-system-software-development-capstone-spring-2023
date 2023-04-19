package com.inventorymanagementsystem.inventory.management.system.data;

import com.inventorymanagementsystem.inventory.management.system.domain.Supplier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SupplierDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Supplier> getAll() {
        return entityManager.createQuery("Select s from Supplier s", Supplier.class).getResultList();
    }
}

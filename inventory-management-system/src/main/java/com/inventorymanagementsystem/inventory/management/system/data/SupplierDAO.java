package com.inventorymanagementsystem.inventory.management.system.data;

import com.inventorymanagementsystem.inventory.management.system.domain.Supplier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers <br>
 * Date: 4/19/23 <br>
 * Class: SupplierDAO <br>
 * Description: This class is used to retrieve data from teh Suppliers table in the database.
 */
@Repository
@Transactional
public class SupplierDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final SupplierRepository supplierRepository;

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Constructor: SupplierDAO <br>
     * Description: This constructor is used to inject a SupplierRepository.
     * @param supplierRepository is a SupplierRepository interface.
     */
    public SupplierDAO(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    /**
     * Date: 4/19/23
     * @param supplier
     * @return
     */
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    /**
     * Date: 4/19/23
     * @param supplierList
     * @return
     */
    public List<Supplier> save(List<Supplier> supplierList) {
        return supplierRepository.saveAll(supplierList);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Method: getAll <br>
     * Description: Returns a list of suppliers from the database.
     * @return list of suppliers
     */
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Method: getSupplierById
     * @param id is the id of the supplier in the database.
     * @return a Supplier object
     */
    public Optional<Supplier> getSupplierById(String id) {
        long convertId = Long.parseLong(id);
        return supplierRepository.findById(convertId);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/20/23 <br>
     * @param supplier
     */
    public Optional<Supplier> update(Supplier supplier) {
        entityManager.merge(supplier);
        return getSupplierById(String.valueOf(supplier.getSupplierID()));
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/20/23 <br>
     * @param id
     */
    public void deleteById(long id) {
        supplierRepository.deleteById(id);
    }
}

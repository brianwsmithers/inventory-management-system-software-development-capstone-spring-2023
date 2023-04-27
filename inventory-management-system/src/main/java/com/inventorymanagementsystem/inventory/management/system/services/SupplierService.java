package com.inventorymanagementsystem.inventory.management.system.services;

import com.inventorymanagementsystem.inventory.management.system.data.SupplierDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers <br>
 * Date: 4/19/23 <br>
 * Class: SupplierService <br>
 * Description: This class is used to validate any requests from the <code>SupplierController</code> before
 * they pass through to the <code>SupplierDAO</code>.
 */
@Service
public class SupplierService {

    private final SupplierDAO supplierDAO;

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Constructor: SupplierService <br>
     * Description: This constructor is used to inject a SupplierDAO.
     * @param supplierDAO
     */
    public SupplierService(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Method: getAll <br>
     * Description: Returns a list of suppliers from the database.
     * @return list of suppliers
     */
    public List<Supplier> getAll() {
        return supplierDAO.getAll();
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Method: getSupplierById <br>
     * Description: This method is used to return a single supplier from the database.
     * @param id is the id of the supplier in the table
     * @return a supplier object
     */
    public Optional<Supplier> getSupplierById(String id) {
        return supplierDAO.getSupplierById(id);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * @param supplierList
     * @return
     */
    public List<Supplier> saveSuppliers(List<Supplier> supplierList) {
        return supplierDAO.save(supplierList);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * @param supplier
     * @return
     */
    public Supplier saveSupplier(Supplier supplier) {
        return supplierDAO.save(supplier);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/20/23 <br>
     * @param supplier
     * @return
     */
    public Optional<Supplier> updateSupplier(Supplier supplier) {
        return supplierDAO.update(supplier);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/20/23 <br>
     * @param id
     */
    public void deleteById(String id) {
        long convertedId = Long.parseLong(id);
        supplierDAO.deleteById(convertedId);
    }
}

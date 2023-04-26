package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.domain.Supplier;
import com.inventorymanagementsystem.inventory.management.system.services.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers <br>
 * Date: 4/18/23 <br>
 * Class: SupplierController <br>
 * Description:
 */
@RestController
public class SupplierController {
    private final SupplierService supplierService;

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Constructor: SupplierController <br>
     * Description: This constructor is used to inject a SupplierService.
     * @param supplierService is a SupplierService object.
     */
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Method: supplierList <br>
     * Description: Returns a list of suppliers from the database.
     * @return list of suppliers
     */
    @GetMapping(value = "suppliers")
    public List<Supplier> supplierList() {
        return supplierService.getAll();
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Method: supplierById <br>
     * Description: This method is used to return a single supplier from the database.
     * @param id is the id of the supplier in the table
     * @return a supplier object
     */
    @GetMapping(value = "supplier/{id}")
    public Optional<Supplier> getSupplierById(@PathVariable String id) {
        return supplierService.getSupplierById(id);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Method: suppliers <br>
     * Description: takes in a list of suppliers to create in the database.
     * @param suppliers is a list of supplier objects
     * @return a list of suppliers that were created.
     */
    @PostMapping(value = "suppliers")
    public List<Supplier> saveSuppliers(@RequestBody List<Supplier> suppliers) {
        return supplierService.saveSuppliers(suppliers);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * @param supplier
     * @return
     */
    @PostMapping(value = "supplier")
    public Supplier saveSupplier(@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Method: updateSupplier <br>
     * Description: Updates a suppliers information in the database.
     *
     * @param supplier is a supplier object
     * @return
     */
    @PutMapping(value = "supplier")
    public Optional<Supplier> updateSupplier(@RequestBody Supplier supplier) {
        return supplierService.updateSupplier(supplier);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/19/23 <br>
     * Method: deleteSupplier <br>
     * Description: Deletes a supplier in the database.
     * @param id is the id of the supplier in the database
     */
    @DeleteMapping(value = "supplier/{id}")
    public void deleteSupplier(@PathVariable String id) {
        supplierService.deleteById(id);
    }
}

package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.data.SupplierDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Brian Smithers <br>
 * Date: 4/18/23 <br>
 * Class: SupplierController <br>
 * Description:
 */
@RestController
public class SupplierController {
    private final SupplierDAO supplierDAO;

    public SupplierController(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }

    @RequestMapping(value = "suppliers", method = RequestMethod.GET)
    public List<Supplier> supplierList() {
        return supplierDAO.getAll();
    }

}

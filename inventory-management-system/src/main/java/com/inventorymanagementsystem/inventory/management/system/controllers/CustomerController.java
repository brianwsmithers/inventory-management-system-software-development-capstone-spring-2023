package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CustomerController {

    @GetMapping(value = "v1/Customer/{customer")
    public Customer getCustomerById(@PathVariable("customerId") Integer id) {
     return new Customer();
    }


}

package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import com.inventorymanagementsystem.inventory.management.system.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "v1/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(@PathVariable("customerId") Integer id) {

        return new Customer();
    }


}

package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerService;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers/", params = "customerId")
    public Optional<Customer> getCustomerById(@RequestParam("customerId") long id) {
        //TODO validate that input is long
        return customerService.get(id);
    }
}

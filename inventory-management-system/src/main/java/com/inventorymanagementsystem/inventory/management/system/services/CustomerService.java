package com.inventorymanagementsystem.inventory.management.system.services;

import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public static Customer getCustomerById(Integer customerId) {
        return new Customer();
    }
}

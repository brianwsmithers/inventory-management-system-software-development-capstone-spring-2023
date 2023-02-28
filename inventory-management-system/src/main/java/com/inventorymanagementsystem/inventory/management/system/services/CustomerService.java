package com.inventorymanagementsystem.inventory.management.system.services;


import com.inventorymanagementsystem.inventory.management.system.repositories.Customer;
import com.inventorymanagementsystem.inventory.management.system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerById(Long customerId) throws Exception {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Can not find customer Id : " + customerId));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}

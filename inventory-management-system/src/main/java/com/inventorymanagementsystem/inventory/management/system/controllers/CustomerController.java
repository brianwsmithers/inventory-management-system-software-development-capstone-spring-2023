package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import com.inventorymanagementsystem.inventory.management.system.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Authors: Elleni, Brian <br>
 * Date: 2/25/23 <br>
 * Class: CustomerController <br>
 * Description:

 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Author: Elleni, Brian <br>
     * Date: 2/28/23
     * Method: getCustomerById
     * Description:
     * @param id
     * @return
     */
    @RequestMapping(value = "/customers", params = "customerId")
    public Optional<Customer> getCustomerById(@RequestParam("customerId") long id) {
        return customerService.getCustomer(id);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/28/23<br>
     * Method: getCustomerByName<br>
     * Description:
     * @param firstName
     * @param lastName
     * @return
     */
    @RequestMapping(value = "/getCustomerByName")
    public List<Optional<Customer>> getCustomerByName(@RequestParam String firstName, @RequestParam String lastName) {
        return customerService.getCustomerByFirstAndLastName(firstName, lastName);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: createCustomer<br>
     * Description:
     * @param customer
     * @return
     */
    @PostMapping(value = "/createCustomer")
    public String createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/14/23<br>
     * Method: updateCustomerById<br>
     * Description:
     * @param customer
     * @return
     */
    @PutMapping(value = "/updateCustomerById")
    public String updateCustomerById(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/14/23<br>
     * Method: deleteCustomerById<br>
     * Description:
     * @param customer
     * @return
     */
    @DeleteMapping(value = "/deleteCustomerById")
    public String deleteCustomerById(@RequestBody Customer customer) {
        return customerService.deleteCustomer(customer);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/16/23<br>
     * Method: getAllCustomers<br>
     * Description:
     * @return
     */
    @GetMapping(value = "/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}

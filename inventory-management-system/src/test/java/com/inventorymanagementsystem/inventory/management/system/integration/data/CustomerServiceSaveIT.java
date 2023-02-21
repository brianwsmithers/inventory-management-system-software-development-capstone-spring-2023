package com.inventorymanagementsystem.inventory.management.system.integration.data;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerService;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Brian Smithers<br>
 * Date: 2/20/23<br>
 * Class: CustomerDAOSaveIT<br>
 * Description:
 */
public class CustomerServiceSaveIT {

    /**
     * Date: 2/20/23
     */
    @Test
    public void saveValidCustomerTest() {
        // Arrange
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer("Frank", "Hollow", "1237 Imaginery Lane",
                "8641246710", "fhollow@ggc.edu", null);
        Optional<Customer> customerOptional;

        // Act
        customerService.save(customer);
        customerOptional = customerService.get(5);

        // Assert
        assertTrue(customerOptional.isPresent());
    }
}

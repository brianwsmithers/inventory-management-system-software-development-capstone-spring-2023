package com.inventorymanagementsystem.inventory.management.system.integration.data.customer;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Author: Brian Smithers<br>
 * Date: 3/15/23<br>
 */
public class UpdateIT {

    private CustomerDAO customerDAO;

    @BeforeEach
    public void setUp() {
        customerDAO = new CustomerDAO();
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: updateAddressForACustomer<br>
     * Description:
     */
    @Test
    public void updateAddressForACustomer() {
        // Arrange
        String newAddress = "6000 Imaginary Lane";
        Customer customer = new Customer(25, "Jamie", "Foxx", newAddress,
                "1111111111", "jfoxx@ggc.edu", null);
        Optional<Customer> updatedCustomer;
        String actual = null;

        // Act
        customerDAO.update(customer);
        updatedCustomer = customerDAO.get(25L);

        if (updatedCustomer.isPresent()) {
            actual = updatedCustomer.get().getAddress();
        }

        // Assert
        Assertions.assertEquals(newAddress, actual, "The address should be 6000 Imaginary Lane" +
                " if the update method is successfully called.");
    }
}

package com.inventorymanagementsystem.inventory.management.system.integration.data.customer;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers<br>
 * Date: 2/20/23<br>
 * Class: CustomerDAOSaveIT<br>
 * Description: The purpose of this class is to test the save functionality for the customer feature. The save
 * functionality is responsible for saving new customers to the database.
 */
public class SaveIT {

    private CustomerDAO customerDAO;

    @BeforeEach
    public void setUp() {
        customerDAO = new CustomerDAO();
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: saveValidCustomerTest<br>
     * Description: The purpose of this test is to verify that the <code>save</code> method saves a new customer
     * to the "customers" table in the database.
     */
    @Test
    public void saveValidCustomerTest() {
        // Arrange
        String firstName = "Frank";
        String lastName = "Hollow";

        Customer customer = new Customer(firstName, lastName, "1237 Imaginary Lane",
                "8641246710", "fhollow@ggc.edu", null);
        List<Optional<Customer>> customerList;

        int expected = 1;
        int actual;

        // Act
        customerDAO.save(customer);
        customerList = customerDAO.getCustomerByFirstAndLastName(firstName, lastName);
        actual = customerList.size();

        // Assert
        Assertions.assertEquals(expected, actual, "The list should be size 1 if Frank was added to the " +
                "database successfully.");
    }
}

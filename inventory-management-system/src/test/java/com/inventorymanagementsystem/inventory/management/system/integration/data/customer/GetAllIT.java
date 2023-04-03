package com.inventorymanagementsystem.inventory.management.system.integration.data.customer;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Author: Brian Smithers<br>
 * Date: 3/15/23<br>
 * Class: CustomerDAOGetAllIT<br>
 * Description: The purpose of this class is to test that all customers can be retrieved from the "customers" table
 * in the database.
 */
public class GetAllIT {

    private CustomerDAO customerDAO;

    @BeforeEach
    public void setUp() {
        customerDAO = new CustomerDAO();
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: getAllCustomersFromDatabase<br>
     * Description: The purpose of this method is to test that all customers are retrieved from the database.
     */
    @Test
    public void getAllCustomersFromDatabaseTest() {
        // Arrange
        List<Customer> customerList = null;
        int size;
        int expected = 5;

        // Act
        customerList = customerDAO.getAll();
        size = customerList.size();

        // Assert
        Assertions.assertEquals(expected, size,
                "The current size of the database is 4 entries so it should return 4.");
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: getAllCustomersFromDatabaseVerifyThatChaseGrizzleExists
     * Description: The purpose of this method is to verify that Chase Grizzle is found in the database when the
     * getAll method is called. This test verifies that at least 1 customer is successfully retrieved.
     */
    @Test
    public void getAllCustomersFromDatabaseVerifyThatChaseGrizzleExists() {
        // Arrange
        String firstName = null;
        String nameToCheck = "Chase";
        List<Customer> customerList = null;

        // Act
        customerList = customerDAO.getAll();

        for (Customer customer : customerList) {
            if (customer.getFirstName().equals(nameToCheck)) {
                firstName = customer.getFirstName();
            }
        }

        // Assert
        Assertions.assertEquals(nameToCheck, firstName, "Chase is currently in the database so this name" +
                " should appear since the getAll test returns the correct size.");
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: getAllCustomersFromDatabaseVerifyThatACustomerDoesNotExist<br>
     * Description: The purpose of this method is to test that a non-customer is not in the database. This test
     * verifies that the getAll method is only returning valid customers from the database.
     */
    @Test
    public void getAllCustomersFromDatabaseVerifyThatACustomerDoesNotExist() {
        // Arrange
        String firstName = null;
        String nameToCheck = "Billy";
        List<Customer> customerList = null;

        // Act
        customerList = customerDAO.getAll();

        for (Customer customer : customerList) {
            if (customer.getFirstName().equals(nameToCheck)) {
                firstName = customer.getFirstName();
            }
        }

        // Assert
        Assertions.assertNull(firstName, "This test should return null because Billy is not" +
                "in the database.");
    }
}

package com.inventorymanagementsystem.inventory.management.system.integration.data.customer;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers<br>
 * Date: 2/27/23<br>
 * Class: CustomerDAOGetByNameIT<br>
 * Description: The purpose of this class is to test that a customer can be retrieved from the databas by their first
 * and last name.
 */

public class GetByNameIT {

    private CustomerDAO customerDAO;

    @BeforeEach
    public void setUp() {
        customerDAO = new CustomerDAO();
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: getCustomerByFirstAndLastNameValidTest<br>
     * Description: The purpose of this test is to verify that a valid customer can be retrieved by their first and
     * last name by calling the <code>getCustomerByFirstAndLastName</code> method.
     */
    @Test
    public void getCustomerByFirstAndLastNameValidTest() {
        // Arrange
        String firstName = "Jim";
        String lastName = "Baker";
        List<Optional<Customer>> customerList;
        String firstNameFromQuery = null;

        // Act
        customerList = customerDAO.getByFirstAndLastName(firstName, lastName);
        Optional<Customer> customer = customerList.get(0);

        if (customer.isPresent()) {
            firstNameFromQuery = customer.get().getFirstName();
        }

        // Assert
        Assertions.assertEquals(firstName, firstNameFromQuery);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: getCustomerByFirstAndLastNameInvalidTest<br>
     * Description: The purpose of this test is to verify that a non-customer is not returned when calling the
     * <code>getCustomerByFirstAndLastName</code> method.
     */
    @Test
    public void getCustomerByFirstAndLastNameInvalidTest() {
        // Arrange
        String firstName = "John";
        String lastName = "Wilkins";
        List<Optional<Customer>> customerList;
        int expected = 0;
        int actual;

        // Act
        customerList = customerDAO.getByFirstAndLastName(firstName, lastName);
        actual = customerList.size();

        // Assert
        Assertions.assertEquals(expected, actual, "The size should be 0 because there is no John Wilkins" +
                " in the database.");
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: getCustomerByFirstAndLastNameWhere2CustomersHaveTheSameFirstAndLastName<br>
     * Description: The purpose of this test is to verify that all customers with the same first and last name
     * will be returned when the <code>getCustomerByFirstAndLastName</code> method is called.
     */
    @Test
    public void getCustomerByFirstAndLastNameWhere2CustomersHaveTheSameFirstAndLastName() {
        // Arrange
        String firstName = "Bob";
        String lastName = "Rivera";
        List<Optional<Customer>> customerList;
        int expected = 2;
        int actualSize;

        // Act
        customerList = customerDAO.getByFirstAndLastName(firstName, lastName);
        actualSize = customerList.size();

        // Assert
        Assertions.assertEquals(expected, actualSize, "There are currently two Bob Rivera's in the database" +
                " so the size of the list should return 2.");
    }
}

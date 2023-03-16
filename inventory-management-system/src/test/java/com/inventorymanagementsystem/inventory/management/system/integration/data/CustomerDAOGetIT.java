package com.inventorymanagementsystem.inventory.management.system.integration.data;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Author: Brian Smithers<br>
 * Date: 2/19/23<br>
 * Class: CustomerDAOIT<br>
 * Description: This class is used to test the Customer Data Access Object interface for the Get method. This test
 * class does not test for the StaffID value at this time..
 */
public class CustomerDAOGetIT {

    private CustomerDAO customerDAO;

    @BeforeEach
    public void setUp() {
        customerDAO = new CustomerDAO();
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/19/23<br>
     * Method: getIDisNotNullTest<br>
     * Description: The test will retrieve a <code>Customer</code> object from the Customers table in the
     * database.
     */
    @Test
    public void getIDisNotNullTest() {
        // Arrange
        long id = 1L;
        Optional<Customer> customer;

        // Act
        customer = customerDAO.get(id);

        // Assert
        assertTrue(customer.isPresent());
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/19/23<br>
     * Method: getIDIsNullTest<br>
     * Description: The test will retrieve a <code>Customer</code> object from the Customers table in the
     * database, but it will fail because the id does not exist within the database.
     */
    @Test
    public void getIDIsNullTest() {
        // Arrange
        long id = 100L;
        Optional<Customer> customer;

        // Act
        customer = customerDAO.get(id);

        // Assert
        assertEquals(Optional.empty(), customer);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/20/23<br>
     * Method: getValidCustomerNameFromIDTest<br>
     * Description: This method will test if a valid <code>Customer</code> object returns the expected first name.
     */
    @Test
    public void getValidCustomerNameFromIDTest() {
        // Arrange
        long id = 3L;
        Optional<Customer> customer;
        String firstName = null;

        // Act
        customer = customerDAO.get(id);
        if (customer.isPresent()) {
            firstName = customer.get().getFirstName();
        }

        // Assert
        assertEquals("Jim", firstName);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/20/23<br>
     * Method: getValidCustomerLastNameFromIDTest<br>
     * Description: This method will test if a valid <code>Customer</code> object returns the expected last name.
     */
    @Test
    public void getValidCustomerLastNameFromIDTest() {
        // Arrange
        long id = 1L;
        Optional<Customer> customer;
        String lastName = null;

        // Act
        customer = customerDAO.get(id);
        if (customer.isPresent()) {
            lastName = customer.get().getLastName();
        }

        // Assert
        assertEquals("Smithers", lastName);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/20/23<br>
     * Method: getValidCustomerAddressFromIDTest<br>
     * Description: This method will test if a valid <code>Customer</code> object returns the expected address.
     */
    @Test
    public void getValidCustomerAddressFromIDTest() {
        // Arrange
        long id = 1L;
        Optional<Customer> customer;
        String address = null;

        // Act
        customer = customerDAO.get(id);
        if (customer.isPresent()) {
            address = customer.get().getAddress();
        }

        // Assert
        assertEquals("1234 Imaginery Lane", address);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/20/23<br>
     * Method: getValidPhoneNumberFromIDTest<br>
     * Description: This method will test if a valid <code>Customer</code> object returns the expected phone number.
     */
    @Test
    public void getValidPhoneNumberFromIDTest() {
       // Arrange
       long id = 1L;
       Optional<Customer> customer;
       String phone = null;

       // Act
        customer = customerDAO.get(id);
        if (customer.isPresent()) {
            phone = String.valueOf(customer.get().getPhone());
        }

        // Assert
        assertEquals("8641236789", phone);
    }


}

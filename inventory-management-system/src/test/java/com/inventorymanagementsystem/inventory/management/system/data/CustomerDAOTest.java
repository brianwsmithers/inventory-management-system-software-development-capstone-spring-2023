package com.inventorymanagementsystem.inventory.management.system.data;

import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Author: Brian Smithers<br>
 * Date: 2/19/23<br>
 * Class: CustomerDAOTest<br>
 * Description:
 */
public class CustomerDAOTest {

    private CustomerDAO customerDAO;


    /**
     * Author: Brian Smithers<br>
     * Date: 2/19/23<br>
     * Method: getIDisNotNull<br>
     * Description: 
     */
    @Test
    public void getIDisNotNull() {
        // Arrange
        customerDAO = new CustomerDAO();
        int id = 1;
        Optional<Customer> customer;

        // Act
        customer = customerDAO.get(id);

        // Assert
        Assertions.assertNotNull(customer);
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/19/23<br>
     * Method: getIDisNull<br>
     * Description:
     */
    @Test
    public void getIDIsNull() {
        // Arrange
        customerDAO = new CustomerDAO();
        int id = 100;
        Optional<Customer> customer;

        // Act
        customer = customerDAO.get(id);

        // Assert
        Assertions.assertEquals(Optional.empty(), customer);
    }
}

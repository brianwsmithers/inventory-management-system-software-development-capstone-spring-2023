package com.inventorymanagementsystem.inventory.management.system.services;

import com.inventorymanagementsystem.inventory.management.system.data.CustomerDAO;
import com.inventorymanagementsystem.inventory.management.system.data.GetByNameable;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import com.inventorymanagementsystem.inventory.management.system.utilities.StringValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.inventorymanagementsystem.inventory.management.system.utilities.StringFormatters.databaseActionStringFormatter;

/**
 * Author: Brian Smithers <br>
 * Date: 2/25/23 <br>
 * Class: CustomerService <br>
 * Description: <br>
 */
@Service
public class CustomerService implements GetByNameable<Customer> {

    private int rows;

    @Autowired
    private CustomerDAO customerDAO;

    /**
     * Author: Brian Smithers <br>
     * Date: 2/28/23 <br>
     * Method: getCustomer
     * Description:
     * @param id
     * @return
     */
    public Optional<Customer> getCustomer(long id) {
        if (id > 0) {
            return customerDAO.get(id);
        }
        return Optional.empty();
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * Method: getByFirstAndLastName <br>
     * Description:
     * @param firstName
     * @param lastName
     * @return
     */
    @Override
    public List<Optional<Customer>> getByFirstAndLastName(String firstName, String lastName) {
        firstName = StringValidators.validateNames(firstName);
        lastName = StringValidators.validateNames(lastName);

        if (firstName != null && lastName != null) {
            return customerDAO.getByFirstAndLastName(firstName, lastName);
        }
        return null;
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/16/23<br>
     * Method: getAllCustomers
     * Description:
     * @return
     */
    public List<Customer> getAllCustomers() {
        return customerDAO.getAll();
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: createCustomer<br>
     * Description:
     * @param customer
     * @return
     */
    public String createCustomer(Customer customer) {
        rows = 0;

        if (customer != null) {
            rows = customerDAO.save(customer);
            return databaseActionStringFormatter(rows, "created");
        }

        return null;
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/14/23<br>
     * Method:updateCustomer<br>
     * Description:
     * @param customer
     * @return
     */
    public String updateCustomer(Customer customer) {
        rows = 0;

        if (customer.getCustomerId() > 0) {
            rows = customerDAO.update(customer);
            return databaseActionStringFormatter(rows, "update");
        }

        return null;
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: deleteCustomer<br>
     * Description:
     * @param customer
     * @return
     */
    public String deleteCustomer(Customer customer) {
        rows = 0;

        if (customer.getCustomerId() > 0) {
            rows = customerDAO.delete(customer);
            return databaseActionStringFormatter(rows, "delete");
        }

        return null;
    }
}

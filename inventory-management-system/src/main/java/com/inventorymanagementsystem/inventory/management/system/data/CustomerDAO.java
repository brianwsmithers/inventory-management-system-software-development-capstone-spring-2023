package com.inventorymanagementsystem.inventory.management.system.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Brian Smithers<br>
 * Date: 2/19/23<br>
 * Class: CustomerDAO<br>
 * Description:
 */
@Service
public class CustomerDAO implements DAO<Customer> {

    @Autowired
    private final Database database = Database.getInstance();

    private ResultSet resultSet;

    private long customerID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String staffID = null;

    /**
     * Author: Brian Smithers<br>
     * Date: 2/19/23 <br>
     * Method: get<br>
     * Description: This method is used to retrieve a <code>Customer</code> object from the database matching it
     * with their id number in the database.
     * @param id is a long value
     * @return <code>Optional</code> object with a type of <code>Customer</code>.
     */
    @Override
    public Optional<Customer> get(long id) {

        Customer customer = null;

        String query =
                "SELECT customer_id, first_name, last_name, address, phone, email " +
                        "FROM customers WHERE customer_id = " + id;

        database.connect();

        try {
            resultSet = database.query(query);

            while (resultSet.next()) {
                customerID = resultSet.getLong(resultSet.findColumn("customer_id"));
                firstName = resultSet.getString(resultSet.findColumn("first_name"));
                lastName = resultSet.getString(resultSet.findColumn("last_name"));
                address = resultSet.getString(resultSet.findColumn("address"));
                phone = String.valueOf(resultSet.getLong(resultSet.findColumn("phone")));
                email = resultSet.getString(resultSet.findColumn("email"));

                customer = new Customer(customerID, firstName, lastName, address, phone, email, null);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return Optional.ofNullable(customer);
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/20/23<br>
     * Method: save<br>
     * Description:
     * @param customer
     */
    @Override
    public void save(Customer customer) {
        String query =
                "INSERT INTO customers (customer_id, first_name, last_name, address, phone, email, staff_id)" +
                "values (customers_customer_id_seq.nextval, ?, ?, ?, ?, ?, null)";

        database.connect();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setLong(4, Long.parseLong(customer.getPhone()));
            preparedStatement.setString(5, customer.getEmail());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }
    }

    @Override
    public void update(Customer customer, String[] params) {
    }

    @Override
    public void delete(Customer customer) {

    }
}

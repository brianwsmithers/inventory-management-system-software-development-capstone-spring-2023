package com.inventorymanagementsystem.inventory.management.system.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.inventorymanagementsystem.inventory.management.system.domain.Customer;

/**
 * Author: Brian Smithers<br>
 * Date: 2/19/23<br>
 * Class: CustomerDAO<br>
 * Description:
 */
public class CustomerDAO implements DAO<Customer> {

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
     * Description:
     * @param id
     * @return
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

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void update(Customer customer, String[] params) {

    }

    @Override
    public void delete(Customer customer) {

    }
}

package com.inventorymanagementsystem.inventory.management.system.data;

import com.inventorymanagementsystem.inventory.management.system.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers <br>
 * Date: 3/22/23<br>
 * Class: StaffDAO<br>
 * Description:
 */
@Repository
public class StaffDAO implements DAO<Staff>, GetByNameable<Staff> {

    @Autowired
    private final Database database = Database.getInstance();

    private ResultSet resultSet;

    private PreparedStatement preparedStatement;


    private long staffID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String username;
    private String password;

    /**
     * Author: Brian Smithers <br>
     * Date: 3/22/23 <br>
     * @param id
     * @return
     */
    @Override
    public Optional<Staff> get(long id) {

        Optional<Staff> staff = Optional.empty();

        String query = "SELECT staff_id, first_name, last_name, address, phone, email, username, user_password" +
                " FROM staff WHERE staff_id = ?";

        database.connect();

        preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                staff = retrieveDbOptionalObject();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return staff;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @return
     */
    @Override
    public List<Staff> getAll() {
        final List<Staff> staff = new ArrayList<>();

        final String query = "SELECT * FROM staff";

        database.connect();

        try {
            resultSet = database.query(query);

            while (resultSet.next()) {
                staff.add(retrieveDbObject());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return staff;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 3/22/23 <br>
     * @param staff
     * @return
     */
    @Override
    public int save(Staff staff) {
        final String query =
                "INSERT INTO staff(staff_id, first_name, last_name, address, phone, email, username, user_password)" +
                        "values (staff_staff_ID_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";

        int row;

        database.connect();

        preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setString(1, staff.getFirstName());
            preparedStatement.setString(2, staff.getLastName());
            preparedStatement.setString(3, staff.getAddress());
            preparedStatement.setLong(4, Long.parseLong(staff.getPhone()));
            preparedStatement.setString(5, staff.getEmail());
            preparedStatement.setString(6, staff.getUsername());
            preparedStatement.setString(7, staff.getPassword());

            row = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }
        return row;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 3/22/23 <br>
     * Description: This block of code is responsible for updating a Staff object in a database by executing an SQL
     * query with parameterized values, using a preparedStatement object. It handles potential exceptions and
     * properly closes database resources to ensure data integrity. - Chat GPT
     * @param staff
     * @return
     */
    @Override
    public int update(Staff staff) {
        final String query = "UPDATE staff SET first_name = ?, last_name = ?, address = ?, phone = ?, email = ?," +
                " username = ?, user_password = ? WHERE staff_id = ?";

        int row;

        database.connect();

        preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setString(1, staff.getFirstName());
            preparedStatement.setString(2, staff.getLastName());
            preparedStatement.setString(3, staff.getAddress());
            preparedStatement.setLong(4, Long.parseLong(staff.getPhone()));
            preparedStatement.setString(5, staff.getEmail());
            preparedStatement.setString(6, staff.getUsername());
            preparedStatement.setString(7, staff.getPassword());
            preparedStatement.setLong(8, staff.getStaffId());

            row = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return row;
    }

    @Override
    public int delete(Staff staff) {
        final String query = "DELETE from staff WHERE staff_id = ?";

        int row;

        database.connect();

        preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setLong(1, staff.getStaffId());

            row = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return row;
    }

    /**
     * Author: Brian Smithers <br>
     * Date 3/22/23 <br>
     * @param firstName
     * @param lastName
     * @return
     */
    @Override
    public List<Optional<Staff>> getByFirstAndLastName(String firstName, String lastName) {
        final List<Optional<Staff>> staffList = new ArrayList<>();

        final String query = "SELECT staff_id, first_name, last_name, address, phone, email, username, user_password" +
                " FROM staff WHERE first_name = ? AND last_name = ?";

        database.connect();

        preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                staffList.add(retrieveDbOptionalObject());
            }
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return staffList;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 3/22/23 <br>
     * @return
     * @throws SQLException
     */
    public Optional<Staff> retrieveDbOptionalObject() throws SQLException {
        staffID = resultSet.getLong(resultSet.findColumn("staff_id"));
        firstName = resultSet.getString(resultSet.findColumn("first_name"));
        lastName = resultSet.getString(resultSet.findColumn("last_name"));
        address = resultSet.getString(resultSet.findColumn("address"));
        phone = String.valueOf(resultSet.getLong(resultSet.findColumn("phone")));
        email = resultSet.getString(resultSet.findColumn("email"));
        username = resultSet.getString(resultSet.findColumn("username"));
        password = resultSet.getString(resultSet.findColumn("user_password"));

        return Optional.of(new Staff(staffID, firstName, lastName, address, phone, email,
                username, password));
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @return
     * @throws SQLException
     */
    public Staff retrieveDbObject() throws SQLException {
        staffID = resultSet.getLong(resultSet.findColumn("staff_id"));
        firstName = resultSet.getString(resultSet.findColumn("first_name"));
        lastName = resultSet.getString(resultSet.findColumn("last_name"));
        address = resultSet.getString(resultSet.findColumn("address"));
        phone = String.valueOf(resultSet.getLong(resultSet.findColumn("phone")));
        email = resultSet.getString(resultSet.findColumn("email"));
        username = resultSet.getString(resultSet.findColumn("username"));
        password = resultSet.getString(resultSet.findColumn("user_password"));

        return new Staff(staffID, firstName, lastName, address, phone, email,
                username, password);
    }
}

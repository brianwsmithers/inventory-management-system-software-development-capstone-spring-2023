package com.inventorymanagementsystem.inventory.management.system.data;

import com.inventorymanagementsystem.inventory.management.system.domain.Order;
import com.inventorymanagementsystem.inventory.management.system.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.sql.ResultSet;

@Repository
public class OrderDAO implements DAO<Order> {

    @Autowired
    private final Database database = Database.getInstance();
    private ResultSet resultSet;

    private PreparedStatement preparedStatement;


    private Integer orderID;
    private Date dateOfOrder;
    private  String orderDetails;
    private Integer customerID = null;

    @Override
    public Optional<Order> get(long id) {

        Order order = null;

        String query =
                "SELECT Order_ID, Date_of_Order, Order_Details " +
                        "FROM orders WHERE Order_ID = " + id;

        database.connect();

        try {
            resultSet = database.query(query);

            while (resultSet.next()) {
                orderID = resultSet.getInt(resultSet.findColumn("Order_ID"));
                dateOfOrder = resultSet.getDate(resultSet.findColumn("Date_of_Order"));
                orderDetails = resultSet.getString(resultSet.findColumn("Order_Details"));

                order = new Order((int)orderID, dateOfOrder, orderDetails, null);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return Optional.ofNullable(order);
    }

    public List<Order> get(String date) {

        final List<Order> orderList = new ArrayList<>();
        Order order = null;

        String query =
                "SELECT Order_ID, Date_of_Order, Order_Details " +
                        "FROM ORDERS WHERE Date_of_Order = " + date; // HEre change order_ID to date column from the db
        // AND covert the string date to datetime in oracle

        database.connect();

        try {
            resultSet = database.query(query);

            while (resultSet.next()) {
                orderID = resultSet.getInt(resultSet.findColumn("Order_ID"));
                dateOfOrder = resultSet.getDate(resultSet.findColumn("Date_of_Order"));
                orderDetails = resultSet.getString(resultSet.findColumn("Order_Details"));

                order = new Order((int)orderID, dateOfOrder, orderDetails, null);
                orderList.add(order);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return orderList;
    }

    @Override
    public List<Order> getAll() {
        final List<Order> order = new ArrayList<>();

        final String query = "SELECT * FROM ORDERS";

        database.connect();

        try {
            resultSet = database.query(query);

            while (resultSet.next()) {
                orderID = resultSet.getInt(resultSet.findColumn("Order_ID"));
                dateOfOrder = resultSet.getDate(resultSet.findColumn("Date_of_Order"));
                orderDetails = resultSet.getString(resultSet.findColumn("Order_Details"));

                order.add(new Order(orderID, dateOfOrder, orderDetails, null ));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return order;
    }

    @Override
    public int save(Order order) {
        final String query =
                "INSERT INTO ORDERS (Order_ID, Date_of_Order, Order_Details, Customer_ID) " +
                        "values (ORDERS_ORDER_ID_SEQ.nextval, ?, ?, ?)";
        int row = 0;
        database.connect();

        preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setDate(1, order.getDate_Of_Order());
            preparedStatement.setString(2, order.getOrder_Details());
            preparedStatement.setInt(3, order.getCustomerID());

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
    public int update(Order order) {

        int row=0;

        String query =
                "UPDATE ORDERS " +
                        "SET Order_Details = ? " +
                        "WHERE order_ID = ? ";

        database.connect();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);

            preparedStatement.setString(1, order.getOrder_Details());
            preparedStatement.setInt(2, order.getOrder_ID());

            row=preparedStatement.executeUpdate();
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
    public int delete(Order order) {
        String query =
                "DELETE FROM ORDERS " +
                        "WHERE order_ID = ? ";
        int row=0;

        database.connect();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setInt(1, order.getOrder_ID());

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

}

package com.inventorymanagementsystem.inventory.management.system.domain;

public class Order {
    private Integer orderID;
    private Integer DateOfOrder;
    private String Order_Details;
    private Integer customerID;

    public Order(Integer orderID, Integer dateOfOrder, String order_Details, Integer customerID) {
        this.orderID = orderID;
        DateOfOrder = dateOfOrder;
        Order_Details = order_Details;
        this.customerID = customerID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getDateOfOrder() {
        return DateOfOrder;
    }

    public void setDateOfOrder(Integer dateOfOrder) {
        DateOfOrder = dateOfOrder;
    }

    public String getOrder_Details() {
        return Order_Details;
    }

    public void setOrder_Details(String order_Details) {
        Order_Details = order_Details;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }
}

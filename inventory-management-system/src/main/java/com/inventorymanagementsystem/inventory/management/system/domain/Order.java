package com.inventorymanagementsystem.inventory.management.system.domain;

import java.sql.Date;

/**
 * Author: Eline Gidey<br>
 * Date: 3/31/23<br>
 * Class: Order<br>
 * Description:
 */

public class Order {
    private Integer order_ID;
    private Date date_Of_Order;
    private String order_Details;
    private Integer customerID;

    public Order(Integer order_ID, Date date_Of_Order, String order_Details, Integer customerID) {
        this.order_ID = order_ID;
        this.date_Of_Order = date_Of_Order;
        this.order_Details = order_Details;
        this.customerID = customerID;
    }

    public Integer getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(Integer order_ID) {
        this.order_ID = order_ID;
    }

    public Date getDate_Of_Order() {
        return date_Of_Order;
    }

    public void setDate_Of_Order(Date date_Of_Order) {
        this.date_Of_Order = date_Of_Order;
    }

    public String getOrder_Details() {
        return order_Details;
    }

    public void setOrder_Details(String order_Details) {
        this.order_Details = order_Details;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }
}

package com.inventorymanagementsystem.inventory.management.system.domain;

public class Customer {
    /** This value is auto generated from the database */
    private long customerId;

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private Integer staffID;

    /**
     * Authors: Elleni, Brian<br>
     * Date: 2/20/23<br>
     * Constructor: Customer<br>
     * Description: This constructor is for getting a <code>Customer</code> object from the database.
     * @param customerId
     * @param firstName
     * @param lastName
     * @param address
     * @param phone
     * @param email
     * @param staffID
     */
    public Customer(long customerId, String firstName, String lastName, String address, String phone, String email, Integer staffID) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.staffID = staffID;
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 2/20/23<br>
     * Constructor: Customer<br>
     * Description: This constructor is for creating a <code>Customer</code> object for the database.
     * @param firstName
     * @param lastName
     * @param address
     * @param phone
     * @param email
     * @param staffID
     */
    public Customer(String firstName, String lastName, String address, String phone, String email, Integer staffID) {
        if (firstName.length() <= 40) {
            this.firstName = firstName.trim();
        }
        else {
            this.firstName = null;
        }

        if (lastName.length() <= 40) {
            this.lastName = lastName.trim();
        }
        else {
            this.lastName = null;
        }

        if (address.length() <= 40) {
            this.address = address;
        }
        else {
            this.address = null;
        }

        if (phone.length() == 10) {
            this.phone = phone;
        }
        else {
            this.phone = null;
        }

        if (email.length() <= 40) {
            this.email = email;
        }
        else {
            this.email = null;
        }

        this.staffID = staffID;
    }

    public Customer(){
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", fname='" + firstName + '\'' +
                ", lname='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", staffID=" + staffID +
                '}';
    }
}

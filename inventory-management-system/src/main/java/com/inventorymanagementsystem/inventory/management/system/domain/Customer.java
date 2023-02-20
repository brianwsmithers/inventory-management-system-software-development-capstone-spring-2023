package com.inventorymanagementsystem.inventory.management.system.domain;

public class Customer {
    private long customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private Integer staffID;

    public Customer(long customerId, String firstName, String lastName, String address, String phone, String email, Integer staffID) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.staffID = staffID;
    }

    public Customer(){

    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

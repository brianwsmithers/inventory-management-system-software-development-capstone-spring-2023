package com.inventorymanagementsystem.inventory.management.system.domain;

public class Customer {
    private Integer customerId;
    private String fname;
    private String lname;
    private String address;
    private String phone;
    private String email;
    private Integer staffID;

    public Customer(Integer customerId, String fname, String lname, String address, String phone, String email, Integer staffID) {
        this.customerId = customerId;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.staffID = staffID;
    }

    public Customer(){

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
}

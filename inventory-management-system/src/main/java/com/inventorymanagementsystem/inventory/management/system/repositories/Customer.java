package com.inventorymanagementsystem.inventory.management.system.repositories;



import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

//    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private Integer staffID;

    public Customer(){
    }

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

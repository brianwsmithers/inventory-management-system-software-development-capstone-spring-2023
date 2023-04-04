package com.inventorymanagementsystem.inventory.management.system.domain;

/**
 * Author: Brian Smithers <br>
 * Date: 3/22/23 <br>
 * Class: Staff <br>
 * Description:
 */
public class Staff {

    private long staffID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String username;
    private String password;

    /**
     * Author: Brian Smithers<br>
     * Date: 3/22/23<br>
     * Constructor: Staff<br>
     * Description: This constructor is used to retrieve a staff member from the database.
     * @param staffID
     * @param firstName
     * @param lastName
     * @param address
     * @param phone
     * @param email
     * @param username
     * @param password
     */
    public Staff(long staffID, String firstName, String lastName, String address, String phone, String email,
                 String username, String password) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * Author: Brian Smithers<br>
     * Date: 3/22/23<br>
     * Constructor: Staff<br>
     * Description: This constructor is used to create a new staff member.
     * @param firstName
     * @param lastName
     * @param address
     * @param phone
     * @param email
     * @param username
     * @param password
     */
    public Staff(String firstName, String lastName, String address, String phone, String email, String username,
                 String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public long getStaffID() {
        return staffID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

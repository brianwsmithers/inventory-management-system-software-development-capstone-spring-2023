package com.inventorymanagementsystem.inventory.management.system.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long supplierID;

    private String supplierName;

    private String address;

    private int phone;

    private int fax;

    private String email;

    private String supplierDetails;

    public Supplier() {}

    public Supplier(long supplierID, String supplierName, String address, int phone, int fax, String email, String supplierDetails) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.supplierDetails = supplierDetails;
    }

    @Basic
    @Column(name = "supplierID")
    public long getSupplierID() {
        return supplierID;
    }

    @Basic
    @Column(name = "supplier_name")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fax")
    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "supplier_details")
    public String getSupplierDetails() {
        return supplierDetails;
    }

    public void setSupplierDetails(String supplierDetails) {
        this.supplierDetails = supplierDetails;
    }
}

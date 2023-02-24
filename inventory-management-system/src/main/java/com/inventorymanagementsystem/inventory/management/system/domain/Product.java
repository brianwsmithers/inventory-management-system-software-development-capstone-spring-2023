package com.inventorymanagementsystem.inventory.management.system.domain;

public class Product {

    private Integer Product_ID;
    private String product_name;
    private String product_description;
    private String product_unit;
    private Integer product_price;
    private Integer product_quantity;
    private Integer product_status;
    private String other_details;
    private Integer supplier_ID;
    private Integer category_ID;

    public Product() {}

    public Product(Integer product_ID, String product_name, String product_description, String product_unit, Integer product_price, Integer product_quantity, Integer product_status, String other_details, Integer supplier_ID, Integer category_ID) {
        Product_ID = product_ID;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_unit = product_unit;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_status = product_status;
        this.other_details = other_details;
        this.supplier_ID = supplier_ID;
        this.category_ID = category_ID;
    }

    public Integer getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(Integer product_ID) {
        Product_ID = product_ID;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_unit() {
        return product_unit;
    }

    public void setProduct_unit(String product_unit) {
        this.product_unit = product_unit;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public Integer getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Integer product_quantity) {
        this.product_quantity = product_quantity;
    }

    public Integer getProduct_status() {
        return product_status;
    }

    public void setProduct_status(Integer product_status) {
        this.product_status = product_status;
    }

    public String getOther_details() {
        return other_details;
    }

    public void setOther_details(String other_details) {
        this.other_details = other_details;
    }

    public Integer getSupplier_ID() {
        return supplier_ID;
    }

    public void setSupplier_ID(Integer supplier_ID) {
        this.supplier_ID = supplier_ID;
    }

    public Integer getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(Integer category_ID) {
        this.category_ID = category_ID;
    }
}

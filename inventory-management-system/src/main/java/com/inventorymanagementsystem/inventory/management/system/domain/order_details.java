package com.inventorymanagementsystem.inventory.management.system.domain;

public class order_details {
    private Integer order_detail_ID;
    private Integer unit_price;
    private Integer size;
    private Integer quanity;
    private Integer discount;
    private Integer total;
    private Integer date_of_order_detail;
    private Integer product_ID;
    private Integer order_ID;
    private Integer bill_number;

    public order_details() {}

    public order_details(Integer order_detail_ID, Integer unit_price, Integer size, Integer quanity, Integer discount, Integer total, Integer date_of_order_detail, Integer product_ID, Integer order_ID, Integer bill_number) {
        this.order_detail_ID = order_detail_ID;
        this.unit_price = unit_price;
        this.size = size;
        this.quanity = quanity;
        this.discount = discount;
        this.total = total;
        this.date_of_order_detail = date_of_order_detail;
        this.product_ID = product_ID;
        this.order_ID = order_ID;
        this.bill_number = bill_number;
    }

    public Integer getOrder_detail_ID() {
        return order_detail_ID;
    }

    public void setOrder_detail_ID(Integer order_detail_ID) {
        this.order_detail_ID = order_detail_ID;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getQuanity() {
        return quanity;
    }

    public void setQuanity(Integer quanity) {
        this.quanity = quanity;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDate_of_order_detail() {
        return date_of_order_detail;
    }

    public void setDate_of_order_detail(Integer date_of_order_detail) {
        this.date_of_order_detail = date_of_order_detail;
    }

    public Integer getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(Integer product_ID) {
        this.product_ID = product_ID;
    }

    public Integer getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(Integer order_ID) {
        this.order_ID = order_ID;
    }

    public Integer getBill_number() {
        return bill_number;
    }

    public void setBill_number(Integer bill_number) {
        this.bill_number = bill_number;
    }
}

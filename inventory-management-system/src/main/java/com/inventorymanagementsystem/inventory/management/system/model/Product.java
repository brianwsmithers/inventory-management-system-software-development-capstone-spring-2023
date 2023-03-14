package com.inventorymanagementsystem.inventory.management.system.model;

public class Product {

    private String id;
    private String desc;
    private String currStock;
    private String soQty;
    private String poQty;

    public Product(String id, String desc, String currentStock, String soQty, String poQty) {
        this.id = id;
        this.desc = desc;
        this.currStock = currentStock;
        this.soQty = soQty;
        this.poQty = poQty;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrStock() {
        return currStock;
    }

    public void setCurrentStock(String currStock) {
        this.currStock = currStock;
    }

    public String getSoQty() {
        return soQty;
    }

    public void setSoQty(String soQty) {
        this.soQty = soQty;
    }

    public String getPoQty() {
        return poQty;
    }

    public void setPoQty(String poQty) {
        this.poQty = poQty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", currentStock=" + currStock +
                ", soQty=" + soQty +
                ", poQty=" + poQty +
                '}';
    }
}

package com.inventorymanagementsystem.inventory.management.system.domain;

/**
 * Author: Eline Gidey<br>
 * Date: 3/16/23<br>
 * Class: ProductCategory<br>
 * Description:
 */

public class ProductCategory {
    private int category_ID;
    private String category_Name;
    private String description;

    public ProductCategory(Integer category_ID, String category_Name, String description) {
        this.category_ID = category_ID;
        this.category_Name = category_Name;
        this.description = description;
    }

    public Integer getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(Integer category_ID) {
        this.category_ID = category_ID;
    }

    public String getCategory_Name() {
        return category_Name;
    }

    public void setCategory_Name(String category_Name) {
        this.category_Name = category_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

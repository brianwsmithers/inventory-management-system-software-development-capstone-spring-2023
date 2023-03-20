package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.data.CategoryDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Author: Eline Gidey<br>
 * Date: 3/16/23<br>
 * Class: ProductCategoryController<br>
 * Description:
 */

@RestController
public class ProductCategoryController {
    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "/category/", params = "categoryId")
    public Optional<ProductCategory> getCategoryById(@RequestParam("categoryId") int id) {
        return categoryDAO.get(id);
    }
}


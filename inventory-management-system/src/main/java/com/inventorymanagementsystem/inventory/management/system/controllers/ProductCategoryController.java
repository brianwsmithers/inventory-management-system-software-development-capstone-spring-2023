package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.domain.ProductCategory;
import com.inventorymanagementsystem.inventory.management.system.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/category/", params = "categoryId")
    public Optional<ProductCategory> getCategoryById(@RequestParam("categoryId") int id) {
        return productCategoryService.getProductCategory(id);
    }

     @GetMapping(value = "/getAllCategory")
     public List<ProductCategory> getAllCategory(){
        return productCategoryService.getAllProductCategory();
     }

    @PostMapping(value = "/createCategory")
    public String createCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.createProductCategory(productCategory);
    }

    @PutMapping(value = "/updateCategoryById")
    public String updateCategoryById(@RequestBody ProductCategory productCategory) {
        return productCategoryService.updateProductCategory(productCategory);
    }

    @DeleteMapping(value = "/deleteCategoryById")
    public String deleteCategoryById(@RequestBody ProductCategory productCategory) {
        return productCategoryService.deleteProductCategory(productCategory);
    }

}


package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import com.inventorymanagementsystem.inventory.management.system.domain.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    @GetMapping(value = "v1/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getProduct_ID(@PathVariable("product_ID") Integer id) {

        return new Product();
    }

}

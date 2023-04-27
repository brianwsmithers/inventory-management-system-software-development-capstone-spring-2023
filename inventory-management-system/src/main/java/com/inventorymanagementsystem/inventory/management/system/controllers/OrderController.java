package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.domain.Order;
import com.inventorymanagementsystem.inventory.management.system.domain.ProductCategory;
import com.inventorymanagementsystem.inventory.management.system.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", params = "orderID")
    public Optional<Order> getOrderById(@RequestParam("orderID") int id) {
        return orderService.getOrder(id);
    }

    @RequestMapping(value = "/order", params = "dateOfOrder")
    public List<Order> getOrderByDate(@RequestParam("dateOfOrder") String dateOfOrder) {
        return orderService.getOrder(dateOfOrder);
    }

    @GetMapping(value = "/getAllOrder")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    @PostMapping(value = "/createOrder")
    public String createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }


    @PutMapping(value = "/updateOrderById")
    public String updateOrderById(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping(value = "/deleteOrderById")
    public String deleteOrderById(@RequestBody Order order) {
        return orderService.deleteOrder(order);
    }
}

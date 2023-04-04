package com.inventorymanagementsystem.inventory.management.system.services;

import com.inventorymanagementsystem.inventory.management.system.data.OrderDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.inventorymanagementsystem.inventory.management.system.utilities.StringFormatters.databaseActionStringFormatter;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    private int rows;

    public Optional<Order> getOrder(int id){
        if (id > 0) {
            return orderDAO.get(id);
        }
        return Optional.empty();
    }

    public List<Order> getOrder(String date){
        return orderDAO.get(date);
    }

    public List<Order> getAllOrder() {
        return orderDAO.getAll();
    }

    public String createOrder(Order order) {
        rows = 0;

        if (order != null) {
            rows = orderDAO.save(order);
            return databaseActionStringFormatter(rows, "created");
        }

        return null;
    }

    public String updateOrder(Order order) {
        rows = 0;

        if (order.getOrder_ID() > 0){
            rows = orderDAO.update(order);
            return databaseActionStringFormatter(rows, "update");
        }
        return null;
    }

    public String deleteOrder(Order order) {
        rows = 0;

        if(order.getOrder_ID() > 0){
            rows = orderDAO.delete(order);
            return databaseActionStringFormatter(rows, "delete");
        }
        return null;
    }
}

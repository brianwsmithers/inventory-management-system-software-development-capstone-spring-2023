package com.inventorymanagementsystem.inventory.management.system;

import com.inventorymanagementsystem.inventory.management.system.controllers.CustomerController;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerControllerTest {

    @Autowired
    private CustomerController customerController;

    @Test
    public void getCustomerByIdTest(){
        Integer id =1;
        Customer Customer = customerController.getCustomerById(id);



    }
}

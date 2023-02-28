package com.inventorymanagementsystem.inventory.management.system;

import static org.assertj.core.api.Assertions.assertThat;
import com.inventorymanagementsystem.inventory.management.system.controllers.CustomerController;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerControllerTest {

    @Autowired
    private CustomerController CustomerController;

    @Test
    public void getCustomerByIdTest(){
    }
}

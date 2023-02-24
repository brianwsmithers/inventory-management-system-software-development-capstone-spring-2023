package com.inventorymanagementsystem.inventory.management.system;

import static org.assertj.core.api.Assertions.assertThat;
import com.inventorymanagementsystem.inventory.management.system.domain.Customer;
import com.inventorymanagementsystem.inventory.management.system.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void getCustomerByIdTest() {
        Integer id = 1;
        Customer Customer = CustomerService.getCustomerById(id);

        assertThat(Customer.getCustomerId()).isEqualTo(id);
        assertThat(Customer.getFname()).isEqualTo("");

    }
}

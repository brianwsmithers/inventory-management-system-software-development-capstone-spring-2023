package com.inventorymanagementsystem.inventory.management.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Brian Smithers<br>
 * Date: 2/19/23<br>
 * Class: CustomerDAO<br>
 * Description:
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

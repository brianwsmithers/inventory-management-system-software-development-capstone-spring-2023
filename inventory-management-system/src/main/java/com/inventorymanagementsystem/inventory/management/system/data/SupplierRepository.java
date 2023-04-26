package com.inventorymanagementsystem.inventory.management.system.data;

import com.inventorymanagementsystem.inventory.management.system.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}

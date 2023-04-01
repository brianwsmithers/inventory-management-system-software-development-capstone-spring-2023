package com.inventorymanagementsystem.inventory.management.system.integration.data.staff;

import com.inventorymanagementsystem.inventory.management.system.data.StaffDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Author: Brian Smithers <br>
 * Date: 3/22/23 <br>
 * Class: GetIT<br>
 * Description:
 */
public class GetIT {

    private StaffDAO staffDAO;

    @BeforeEach
    public void setup() {
        staffDAO = new StaffDAO();
    }

    @Test
    public void getValidStaffByIDTest() {
        // Arrange
        long id = 1L;
        Optional<Staff> staffOptional;

        // Act
        staffOptional = staffDAO.get(id);

        // Assert
        Assertions.assertTrue(staffOptional.isPresent());
    }
}

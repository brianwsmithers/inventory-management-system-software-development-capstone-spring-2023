package com.inventorymanagementsystem.inventory.management.system.integration.data.staff;

import com.inventorymanagementsystem.inventory.management.system.data.StaffDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Author: Brian Smithers <br>
 * Date: 4/1/23 <br>
 */
public class GetAllIT {

    private StaffDAO staffDAO;

    @BeforeEach
    public void setup() {
        staffDAO = new StaffDAO();
    }


    @Test
    public void getAllTest() {
        // Arrange
        List<Staff> staffList;
        int expected = 2;
        int actual = 0;

        // Act
        staffList = staffDAO.getAll();
        actual = staffList.size();

        // Assert
        Assertions.assertEquals(expected, actual, "Should be 2 because 2 entries are in the database.");
    }
}

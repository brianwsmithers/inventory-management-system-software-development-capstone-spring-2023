package com.inventorymanagementsystem.inventory.management.system.integration.data.staff;

import com.inventorymanagementsystem.inventory.management.system.data.StaffDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Author: Brian Smithers <br>
 * Date: 4/1/23 <br>
 */
public class DeleteIT {

    private StaffDAO staffDAO;

    @BeforeEach
    public void setup() {
        staffDAO = new StaffDAO();
    }

    @Test
    public void deleteTest() {
        // Arrange
        Staff staff = new Staff(21);
        int expected = 1;
        int actual = 0;

        // Act
        actual = staffDAO.delete(staff);

        // Assert
        Assertions.assertEquals(expected, actual, "Should return 1 because 1 row was deleted.");
    }
}

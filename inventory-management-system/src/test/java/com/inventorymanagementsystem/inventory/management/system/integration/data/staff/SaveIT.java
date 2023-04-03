package com.inventorymanagementsystem.inventory.management.system.integration.data.staff;

import com.inventorymanagementsystem.inventory.management.system.data.StaffDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers<br>
 * Date: 3/22/23<br>
 */
public class SaveIT {

    private StaffDAO staffDAO;

    @BeforeEach
    public void setUp() {
        staffDAO = new StaffDAO();
    }

    @Test
    public void saveValidStaffTest() {
        // Arrange
        String firstName = "John";
        String lastName = "Doe";

        Staff staff = new Staff(firstName, lastName, "1235 Imaginary Lane", "1134567890",
                "jdoe@company.com", "jdoe", "password");

        int expected = 1;
        int actual;
        String message = "If the database create a user the value should return 1, else 0.";

        // Act
        actual = staffDAO.save(staff);

        // Assert
        Assertions.assertEquals(expected, actual, message);
    }
}

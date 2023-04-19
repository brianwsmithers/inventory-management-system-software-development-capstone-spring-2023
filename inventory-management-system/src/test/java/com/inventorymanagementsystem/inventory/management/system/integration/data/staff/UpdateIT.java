package com.inventorymanagementsystem.inventory.management.system.integration.data.staff;

import com.inventorymanagementsystem.inventory.management.system.data.StaffDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Staff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Author: Brian Smithers <br>
 * Date: 3/23/23 <br>
 * Class: UpdateIT <br>
 * Description:
 */
public class UpdateIT {

    private StaffDAO staffDAO;

    @BeforeEach
    public void setUp() {
        staffDAO = new StaffDAO();
    }

    @Test
    public void updateAddressForStaff() {
        // Arrange
        String newAddress = "6000 Imaginary Lane";
        Staff staff = new Staff(61L, "Aaron", "Brown", newAddress, "1234567890",
                "abrown@company.com", "abrown", "password");
        int expected = 1;
        int actual;

        // Act
        actual = staffDAO.update(staff);

        // Assert
        Assertions.assertEquals(expected, actual, "If the data was changed, it should return 1.");
    }
}

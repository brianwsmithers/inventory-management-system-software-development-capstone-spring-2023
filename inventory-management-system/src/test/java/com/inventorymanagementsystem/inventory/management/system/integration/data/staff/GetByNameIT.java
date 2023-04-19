package com.inventorymanagementsystem.inventory.management.system.integration.data.staff;

import com.inventorymanagementsystem.inventory.management.system.data.GetByNameable;
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
 * Class: GetByNameIT<br>
 * Description:
 */
public class GetByNameIT {

    private GetByNameable<Staff> getByNameable;

    @BeforeEach
    public void setUp() {
        getByNameable = new StaffDAO();
    }

    @Test
    public void getStaffByFirstAndLastNameValidTest() {
        // Arrange
        String firstName = "Brian";
        String lastName = "Smithers";
        List<Optional<Staff>> staffList;
        String firstNameFromQuery = null;

        // Act
        staffList = getByNameable.getByFirstAndLastName(firstName, lastName);
        Optional<Staff> staff = staffList.get(0);

        if (staff.isPresent()) {
            firstNameFromQuery = staff.get().getFirstName();
        }

        // Assert
        Assertions.assertEquals(firstName, firstNameFromQuery);
    }
}

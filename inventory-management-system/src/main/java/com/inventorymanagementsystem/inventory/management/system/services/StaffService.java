package com.inventorymanagementsystem.inventory.management.system.services;

import com.inventorymanagementsystem.inventory.management.system.data.GetByNameable;
import com.inventorymanagementsystem.inventory.management.system.data.StaffDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.Staff;
import com.inventorymanagementsystem.inventory.management.system.utilities.StringValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.inventorymanagementsystem.inventory.management.system.utilities.StringFormatters.databaseActionStringFormatter;

@Service
public class StaffService implements GetByNameable<Staff> {

    @Autowired
    private StaffDAO staffDAO;

    private int rows;

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @param id
     * @return
     */
    public Optional<Staff> getStaff(long id) {
        if (id > 0) {
            return staffDAO.get(id);
        }
        return Optional.empty();
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @param firstName
     * @param lastName
     * @return
     */
    @Override
    public List<Optional<Staff>> getByFirstAndLastName(String firstName, String lastName) {
        firstName = StringValidators.validateNames(firstName);
        lastName = StringValidators.validateNames(lastName);

        if (firstName != null && lastName != null) {
            return staffDAO.getByFirstAndLastName(firstName, lastName);
        }
        return null;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @return
     */
    public List<Staff> getAllStaff() {
        return staffDAO.getAll();
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @param staff
     * @return
     */
    public String createStaff(Staff staff) {
        rows = 0;

        if (staff != null) {
            rows = staffDAO.save(staff);
            return databaseActionStringFormatter(rows, "created");
        }

        return null;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23
     * @param staff
     * @return
     */
    public String updateStaff(Staff staff) {
        rows = 0;

        if (staff.getStaffId() > 0) {
            rows = staffDAO.update(staff);
            return databaseActionStringFormatter(rows, "update");
        }

        return null;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @param staff
     * @return
     */
    public String deleteStaff(Staff staff) {
        rows = 0;

        if (staff.getStaffId() > 0){
            rows = staffDAO.delete(staff);
            return databaseActionStringFormatter(rows, "delete");
        }

        return null;
    }
}

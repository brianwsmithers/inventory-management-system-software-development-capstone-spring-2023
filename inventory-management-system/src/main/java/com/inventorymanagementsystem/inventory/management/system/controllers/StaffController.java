package com.inventorymanagementsystem.inventory.management.system.controllers;

import com.inventorymanagementsystem.inventory.management.system.domain.Staff;
import com.inventorymanagementsystem.inventory.management.system.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Author: Brian Smithers <br>
 * Date: 4/1/23 <br>
 */
@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @param id
     * @return
     */
    @RequestMapping(value = "/staff", params = "staffId")
    public Optional<Staff> getStaffById(@RequestParam("staffId") long id) {
        return staffService.getStaff(id);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @param firstName
     * @param lastName
     * @return
     */
    @RequestMapping(value = "/getStaffByName")
    public List<Optional<Staff>> getStaffByName(@RequestParam String firstName, @RequestParam String lastName) {
        return staffService.getByFirstAndLastName(firstName, lastName);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @param staff
     * @return
     */
    @PostMapping(value = "/createStaff")
    public String createStaff(@RequestBody Staff staff) {
        return staffService.createStaff(staff);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @param staff
     * @return
     */
    @PutMapping(value = "/updateStaffById")
    public String updateStaffById(@RequestBody Staff staff) {
        return staffService.updateStaff(staff);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * @param staff
     * @return
     */
    @DeleteMapping(value = "/deleteStaffById")
    public String deleteStaffById(@RequestBody Staff staff) {
        return staffService.deleteStaff(staff);
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23
     * @return
     */
    @GetMapping(value = "/getAllStaff")
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }
}

package com.inventorymanagementsystem.inventory.management.system.utilities;

/**
 * Author: Brian Smithers <br>
 * Date: 4/1/23 <br>
 * Class:
 * Description:
 */
public class StringFormatters {

    /**
     * Author: Brian Smithers <br>
     * Date: 4/1/23 <br>
     * Method: databaseActionStringFormatter <br>
     * @param rows
     * @param action
     * @return
     */
    public static String databaseActionStringFormatter(int rows, String action) {
        if (rows > 1 || rows == 0) {
            return String.format("%d rows %s.", rows, action);
        }
        return String.format("%d row %s.", rows, action);
    }
}

package com.inventorymanagementsystem.inventory.management.system.utilities;

import org.apache.commons.lang3.StringUtils;

/**
 * Author: Brian Smithers<br>
 * Date: 3/15/23<br>
 */
public class StringValidators {

    //TODO write test cases
    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: validateNoDigits<br>
     * Description:
     * @param string
     * @return
     */
    private static String validateNoDigits(String string) {
        boolean digitCheckFlag = StringUtils.containsAny("123456790", string);

        if (digitCheckFlag) {
            return null;
        }
        return string;
    }

    //TODO write test cases
    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: validateNotBlank<br>
     * Description:
     * @param string
     * @return
     */
    private static String validateNotBlank(String string) {
        boolean isBlankCheckFlag = StringUtils.isBlank(string);

        if (isBlankCheckFlag) {
            return null;
        }
        return string;
    }

    //TODO write test cases
    /**
     * Author: Brian Smithers<br>
     * Date: 3/15/23<br>
     * Method: validateName
     * Description:
     * @param name
     * @return
     */
    public static String validateNames(String name) {
        String validatedName;

        validatedName = validateNotBlank(name);

        validatedName = name.trim();

        validatedName = validateNoDigits(name);

        return validatedName;
    }
}

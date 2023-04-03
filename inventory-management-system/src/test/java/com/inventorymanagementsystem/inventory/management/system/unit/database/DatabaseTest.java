package com.inventorymanagementsystem.inventory.management.system.unit.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Author: Brian Smithers <br>
 * Date: 2/23/23 <br>
 * Class: DatabaseTest <br>
 * Description:
 */
public class DatabaseTest {

    @Test
    public void inputStreamTest() {
        InputStream inputStream = getClass().getResourceAsStream("/txt/database_credentials");

        Assertions.assertNotNull(inputStream);
    }

    @Test
    public void inputStreamTest2() {
        InputStream inputStream = getClass().getResourceAsStream("/txt/database_credentials");
        assert inputStream != null;
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String result = scanner.nextLine();
            System.out.println(result);
        }
    }
}

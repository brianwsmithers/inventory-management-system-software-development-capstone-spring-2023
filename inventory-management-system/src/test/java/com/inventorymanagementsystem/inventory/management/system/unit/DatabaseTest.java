package com.inventorymanagementsystem.inventory.management.system.unit;

import com.inventorymanagementsystem.inventory.management.system.data.Database;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Author: Brian Smithers<br>
 * Date: 2/23/23
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

package com.inventorymanagementsystem.inventory.management.system.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

/**
 * Author: Brian Smithers <br>
 * Date: 2/19/23 <br>
 * Class: Database <br>
 * Description:
 */
@Component
public class Database {

    @Autowired
    private static Database instance;

    /**
     * Date: 2/19/23
     * @return
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Connection connection;

    /**
     * Date: 2/19/23
     */
    public void connect() {
        String[] credentials = null;

        try {
            credentials = getDatabaseCredentials();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        try {
            assert credentials != null;
            connection = DriverManager.getConnection(credentials[0], credentials[1], credentials[2]);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Date: 2/19/23
     * @return
     */
    private static String[] getDatabaseCredentials() throws IOException {
        String[] credentials = new String[3];
        int i = 0;

        InputStream inputStream;

        try {
            inputStream = Database.class.getResourceAsStream("/txt/database_credentials");
            assert inputStream != null;
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                credentials[i] = scanner.nextLine();
                i++;
            }
            inputStream.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return credentials;
    }

    /**
     * Date: 2/19/23
     */
    public void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Date: 2/19/23
     * @param sqlQuery
     * @return
     */
    public ResultSet query(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();

            return statement.executeQuery(sqlQuery);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Date: 2/20/23
     * @param sqlQuery
     * @return
     */
    public PreparedStatement preparedQuery(String sqlQuery) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return preparedStatement;
    }
}

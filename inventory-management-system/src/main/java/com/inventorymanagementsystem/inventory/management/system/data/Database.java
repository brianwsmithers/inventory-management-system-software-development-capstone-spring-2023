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
 * Description: This class is used to connect, disconnect, and query the database.
 */
@Component
public class Database {

    @Autowired
    private static Database instance;

    /**
     * Author: Brian Smithers <br>
     * Date: 2/19/23 <br>
     * Method: getInstance <br>
     * Description: This method is used to create a Singleton instance of the database class. Currently, this
     * class function properly; however it will need to be updated at some point to reflect Spring Boot's
     * requirements for Singleton classes.
     * @return a <code>Database</code> object.
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Connection connection;

    /**
     * Author: Brian Smithers <br>
     * Date: 2/19/23 <br>
     * Method: connect <br>
     * Description: This method is used to connect to the database.
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
     * Author: Brian Smithers <br>
     * Date: 2/19/23 <br>
     * Method: getDatabaseCredentials <br>
     * Description: This method is used to retrieve the database credentials.
     * @return an array of type <code>String</code> that contains the database credentials.
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
            e.printStackTrace();
        }

        return credentials;
    }

    /**
     * Author: Brian Smithers <br>
     * Date: 2/19/23 <br>
     * Method: closeConnection <br>
     * Description: This method is used to close the connection to the database.
     */
    public void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
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

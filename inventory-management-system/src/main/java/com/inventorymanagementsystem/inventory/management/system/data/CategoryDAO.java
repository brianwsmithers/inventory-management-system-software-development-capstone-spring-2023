package com.inventorymanagementsystem.inventory.management.system.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inventorymanagementsystem.inventory.management.system.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Eline Gidey<br>
 * Date: 3/16/23<br>
 * Class: CategoryDAO<br>
 * Description:
 */

@Service
public class CategoryDAO implements DAO<ProductCategory> {
    @Autowired
    private final Database database = Database.getInstance();

    private ResultSet resultSet;

    private long categoryID;
    private String categoryName;
    private String description;

    @Override
    public Optional<ProductCategory> get(long id) {

        ProductCategory category = null;

        String query =
                "SELECT category_ID, category_Name, category_description " +
                        "FROM PRODUCT_CATEGORY WHERE category_ID = " + id;

        database.connect();

        try {
            resultSet = database.query(query);

            while (resultSet.next()) {
                categoryID = resultSet.getInt(resultSet.findColumn("category_ID"));
                categoryName = resultSet.getString(resultSet.findColumn("category_Name"));
                description = resultSet.getString(resultSet.findColumn("category_description"));


                category = new ProductCategory((int)categoryID, categoryName, description);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return Optional.ofNullable(category);
    }

    @Override
    public List<ProductCategory> getAll() {
        ProductCategory category = null;
        List<ProductCategory> categoryList = new ArrayList<ProductCategory>();
        String query =
                "SELECT category_ID, category_Name, category_description FROM PRODUCT_CATEGORY";

        database.connect();

        try {
            resultSet = database.query(query);

            while (resultSet.next()) {
                categoryID = resultSet.getLong(resultSet.findColumn("category_ID"));
                categoryName = resultSet.getString(resultSet.findColumn("category_Name"));
                description = resultSet.getString(resultSet.findColumn("category_description"));


                category = new ProductCategory((int)categoryID, categoryName, description);
                categoryList.add(category);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }

        return categoryList;
    }


    @Override
    public int save(ProductCategory category) {
        int row;
        String query =
                "INSERT INTO PRODUCT_CATEGORY (category_ID, category_Name, category_description)" +
                        "values (product_category_id_seq.nextval, ?, ?)";

        database.connect();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setString(1, category.getCategory_Name());
            preparedStatement.setString(2, category.getDescription());


            row = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }
        return row;
    }

    @Override
    public int update(ProductCategory category) {
        int row;
        String query =
                "UPDATE PRODUCT_CATEGORY SET category_Name = ?, category_Description = ? " +
                        "WHERE category_ID = ? ";

        database.connect();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setString(1, category.getCategory_Name());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setInt(3, category.getCategory_ID());


            row = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }
        return row;
    }

    @Override
    public int delete(ProductCategory category) {
        int row;
        String query =
                "DELETE FROM PRODUCT_CATEGORY " +
                        "WHERE category_ID = ? ";

        database.connect();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = database.preparedQuery(query);
            preparedStatement.setInt(1, category.getCategory_ID());


            row = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            database.closeConnection();
        }
        return row;
    }
}

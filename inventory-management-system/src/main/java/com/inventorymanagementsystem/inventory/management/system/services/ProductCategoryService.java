package com.inventorymanagementsystem.inventory.management.system.services;

import com.inventorymanagementsystem.inventory.management.system.data.CategoryDAO;
import com.inventorymanagementsystem.inventory.management.system.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static com.inventorymanagementsystem.inventory.management.system.utilities.StringFormatters.databaseActionStringFormatter;

@Service
public class ProductCategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    private int rows;

    public Optional<ProductCategory> getProductCategory(int id) {
        if (id > 0) {
            return categoryDAO.get(id);
        }
        return Optional.empty();
    }

    public List<ProductCategory> getAllProductCategory(){
        return categoryDAO.getAll();
    }

    public String createProductCategory(ProductCategory productCategory){
        rows = 0;

        if (productCategory != null){
            categoryDAO.save(productCategory);
            return databaseActionStringFormatter(rows, "created");
        }
        return null;
    }
    public String updateProductCategory(ProductCategory productCategory){
        rows = 0;

        if (productCategory.getCategory_ID() > 0){
            rows = categoryDAO.update(productCategory);
            return databaseActionStringFormatter(rows, "update");
        }
        return null;
    }

    public String deleteProductCategory(ProductCategory productCategory) {
        rows = 0;

        if (productCategory.getCategory_ID() > 0){
            rows = categoryDAO.delete(productCategory);
            return databaseActionStringFormatter(rows, "delete");
        }
        return null;
    }
}

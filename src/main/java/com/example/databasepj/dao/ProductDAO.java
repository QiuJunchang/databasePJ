package com.example.databasepj.dao;

import com.example.databasepj.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    void addProduct(Product product) throws SQLException;

    void updateProduct(Product product) throws SQLException;

    void deleteProduct(int productID) throws SQLException;

    List<Product> getAllProducts() throws SQLException;

    Product getProductByID(int productID) throws SQLException;
}

package com.example.databasepj.dao;

import com.example.databasepj.entity.Good;
import com.example.databasepj.entity.Product;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {

    private Connection connection;
    private final String url;
    private final String username;
    private final String password;

    public ProductDAO() {
        this.url = "jdbc:mysql://localhost:3306/pj";
        this.username = "admin";
        this.password = "123";
        // 在构造函数中初始化数据库连接
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pj", "admin", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addProduct(Product product) {
//        System.out.println(good);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product (productName, productCategory, productOrigin, productionDate, shelfLife) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductCategory());
            preparedStatement.setString(3, product.getProductOrigin());
            preparedStatement.setDate(4, product.getProductionDate());
            preparedStatement.setInt(5, product.getShelfLife());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM product")) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("ProductName"));
                product.setProductCategory(resultSet.getString("ProductCategory"));
                product.setProductOrigin(resultSet.getString("ProductOrigin"));
                product.setProductionDate(resultSet.getDate("ProductionDate"));
                product.setShelfLife(resultSet.getInt("ShelfLife"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product getProductById(int productId) {
        Product product = null;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE ProductID = ?")) {

            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    product = new Product();
                    product.setProductID(resultSet.getInt("ProductID"));
                    product.setProductName(resultSet.getString("ProductName"));
                    product.setProductCategory(resultSet.getString("ProductCategory"));
                    product.setProductOrigin(resultSet.getString("ProductOrigin"));
                    product.setProductionDate(resultSet.getDate("ProductionDate"));
                    product.setShelfLife(resultSet.getInt("ShelfLife"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public Product getProductByName(String productName) {
        Product product = null;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE ProductName = ?")) {

            statement.setString(1, productName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    product = new Product();
                    product.setProductID(resultSet.getInt("ProductID"));
                    product.setProductName(resultSet.getString("productName"));
                    product.setProductCategory(resultSet.getString("productCategory"));
                    product.setProductOrigin(resultSet.getString("productOrigin"));
                    product.setProductionDate(resultSet.getDate("productionDate"));
                    product.setShelfLife(resultSet.getInt("shelfLife"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public void saveProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO product (productName, productCategory, merchantID, platformID, productOrigin, productionDate, shelfLife) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, product.getProductName());
            statement.setString(2, product.getProductCategory());
            statement.setString(5, product.getProductOrigin());
            statement.setDate(6, product.getProductionDate());
            statement.setInt(7, product.getShelfLife());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 其他自定义方法...
}

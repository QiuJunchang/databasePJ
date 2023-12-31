package com.example.databasepj.dao;

import com.example.databasepj.entity.Product;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {
    private final String url;
    private final String username;
    private final String password;

    public ProductDAO(){
        this.url = "jdbc:mysql://localhost:3306/pj";
        this.username = "admin";
        this.password = "123";
    }
    public ProductDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM product")) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt("ProductID"));
                product.setProductName(resultSet.getString("productName"));
                product.setProductCategory(resultSet.getString("productCategory"));
                product.setMerchantID(resultSet.getInt("merchantID"));
                product.setPlatformID(resultSet.getInt("platformID"));
                product.setProductOrigin(resultSet.getString("productOrigin"));
                product.setProductionDate(resultSet.getDate("productionDate"));
                product.setShelfLife(resultSet.getInt("shelfLife"));
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
                    product.setProductName(resultSet.getString("productName"));
                    product.setProductCategory(resultSet.getString("productCategory"));
                    product.setMerchantID(resultSet.getInt("merchantID"));
                    product.setPlatformID(resultSet.getInt("platformID"));
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
            statement.setInt(3, product.getMerchantID());
            statement.setInt(4, product.getPlatformID());
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

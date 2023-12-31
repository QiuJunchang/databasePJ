package com.example.databasepj.dao;

import com.example.databasepj.entity.ProductPriceInfo;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductPriceInfoDAO {
    private final String url;
    private final String username;
    private final String password;

    public ProductPriceInfoDAO(){
        this.url = "jdbc:mysql://localhost:3306/pj";
        this.username = "admin";
        this.password = "123";
    }
    public ProductPriceInfoDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<ProductPriceInfo> getAllProductPriceInfo() {
        List<ProductPriceInfo> productPriceInfos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM productpriceinfo")) {

            while (resultSet.next()) {
                ProductPriceInfo productPriceInfo = new ProductPriceInfo();
                productPriceInfo.setProductPriceInfoID(resultSet.getInt("ProductPriceInfoID"));
                productPriceInfo.setGoodID(resultSet.getInt("goodID"));
                productPriceInfo.setPriceDate(resultSet.getDate("priceDate"));
                productPriceInfo.setHistoricalPrice(resultSet.getDouble("historicalPrice"));
                productPriceInfos.add(productPriceInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productPriceInfos;
    }

    public ProductPriceInfo getProductPriceInfoById(int productPriceInfoId) {
        ProductPriceInfo productPriceInfo = null;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM productpriceinfo WHERE ProductPriceInfoID = ?")) {

            statement.setInt(1, productPriceInfoId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    productPriceInfo = new ProductPriceInfo();
                    productPriceInfo.setProductPriceInfoID(resultSet.getInt("ProductPriceInfoID"));
                    productPriceInfo.setGoodID(resultSet.getInt("goodID"));
                    productPriceInfo.setPriceDate(resultSet.getDate("priceDate"));
                    productPriceInfo.setHistoricalPrice(resultSet.getDouble("historicalPrice"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productPriceInfo;
    }

    public void saveProductPriceInfo(ProductPriceInfo productPriceInfo) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO productpriceinfo (goodID, priceDate, historicalPrice) VALUES (?, ?, ?)")) {

            statement.setInt(1, productPriceInfo.getGoodID());
            statement.setDate(2, productPriceInfo.getPriceDate());
            statement.setDouble(3, productPriceInfo.getHistoricalPrice());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 其他自定义方法...
}

package com.example.databasepj.dao;

import com.example.databasepj.entity.ProductPriceInfo;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
@Component
public class ProductPriceInfoDAO {
    private Connection connection;

    public ProductPriceInfoDAO(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pj", "admin", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveProductPriceInfo(Date date) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int goodID = resultSet.getInt("goodID");
                int productID = resultSet.getInt("productID");
                Double price = resultSet.getDouble("price");
                int modified = resultSet.getInt("modified");
                if(modified == 0) {
                    PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO productpriceinfo (ProductID, GoodID, PriceDate, HistoricalPrice) VALUES  (?, ?, ?, ?)");
                    preparedStatement1.setInt(1, productID);
                    preparedStatement1.setInt(2, goodID);
                    preparedStatement1.setDate(3, date);
                    preparedStatement1.setDouble(4, price);
                    preparedStatement1.executeUpdate();
                }
                else {
                    resultSet.updateInt("modified",0);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 其他自定义方法...
}

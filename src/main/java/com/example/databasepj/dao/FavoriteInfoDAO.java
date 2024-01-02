package com.example.databasepj.dao;

import com.example.databasepj.entity.FavoriteInfo;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FavoriteInfoDAO {
    private Connection connection;
    public FavoriteInfoDAO(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pj", "admin", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFavoriteInfo(FavoriteInfo favoriteInfo){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO favoriteinfo (userID, goodID, priceFloor) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, favoriteInfo.getUserID());
            preparedStatement.setInt(2, favoriteInfo.getGoodID());
            preparedStatement.setDouble(3, favoriteInfo.getPriceFloor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 其他自定义方法...
}

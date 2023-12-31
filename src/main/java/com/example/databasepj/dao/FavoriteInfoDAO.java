package com.example.databasepj.dao;

import com.example.databasepj.entity.FavoriteInfo;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FavoriteInfoDAO {
    private final String url;
    private final String username;
    private final String password;

    public FavoriteInfoDAO(){
        this.url = "jdbc:mysql://localhost:3306/pj";
        this.username = "admin";
        this.password = "123";
    }

    public FavoriteInfoDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<FavoriteInfo> getAllFavoriteInfo() {
        List<FavoriteInfo> favoriteInfos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM favoriteinfo")) {

            while (resultSet.next()) {
                FavoriteInfo favoriteInfo = new FavoriteInfo();
                favoriteInfo.setFavoriteInfoID(resultSet.getInt("FavoriteInfoID"));
                favoriteInfo.setUserID(resultSet.getInt("userID"));
                favoriteInfo.setGoodID(resultSet.getInt("goodID"));
                favoriteInfo.setPriceFloor(resultSet.getDouble("priceFloor"));
                favoriteInfos.add(favoriteInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return favoriteInfos;
    }

    public FavoriteInfo getFavoriteInfoById(int favoriteInfoId) {
        FavoriteInfo favoriteInfo = null;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM favoriteinfo WHERE FavoriteInfoID = ?")) {

            statement.setInt(1, favoriteInfoId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    favoriteInfo = new FavoriteInfo();
                    favoriteInfo.setFavoriteInfoID(resultSet.getInt("FavoriteInfoID"));
                    favoriteInfo.setUserID(resultSet.getInt("userID"));
                    favoriteInfo.setGoodID(resultSet.getInt("goodID"));
                    favoriteInfo.setPriceFloor(resultSet.getDouble("priceFloor"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return favoriteInfo;
    }

    public void saveFavoriteInfo(FavoriteInfo favoriteInfo) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO favoriteinfo (userID, goodID, priceFloor) VALUES (?, ?, ?)")) {

            statement.setInt(1, favoriteInfo.getUserID());
            statement.setInt(2, favoriteInfo.getGoodID());
            statement.setDouble(3, favoriteInfo.getPriceFloor());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 其他自定义方法...
}

package com.example.databasepj.dao;

import com.example.databasepj.entity.Platform;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PlatformDAO {
    private final String url;
    private final String username;
    private final String password;

    public PlatformDAO(){
        this.url = "jdbc:mysql://localhost:3306/pj";
        this.username = "admin";
        this.password = "123";
    }
    public PlatformDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Platform> getAllPlatforms() {
        List<Platform> platforms = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM platform")) {

            while (resultSet.next()) {
                Platform platform = new Platform();
                platform.setPlatformID(resultSet.getInt("PlatformID"));
                platform.setPlatformName(resultSet.getString("platformName"));
                platforms.add(platform);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return platforms;
    }

    public Platform getPlatformById(int platformId) {
        Platform platform = null;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM platform WHERE PlatformID = ?")) {

            statement.setInt(1, platformId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    platform = new Platform();
                    platform.setPlatformID(resultSet.getInt("PlatformID"));
                    platform.setPlatformName(resultSet.getString("platformName"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return platform;
    }

    public void savePlatform(Platform platform) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO platform (PlatformID, platformName) VALUES (?, ?)")) {

            statement.setInt(1, platform.getPlatformID());
            statement.setString(2, platform.getPlatformName());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 其他自定义方法...
}

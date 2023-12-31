package com.example.databasepj.dao;

import com.example.databasepj.entity.Merchant;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MerchantDAO {
    private final String url;
    private final String username;
    private final String password;

    public MerchantDAO(){
        this.url = "jdbc:mysql://localhost:3306/pj";
        this.username = "admin";
        this.password = "123";
    }
    public MerchantDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Merchant> getAllMerchants() {
        List<Merchant> merchants = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM merchant")) {

            while (resultSet.next()) {
                Merchant merchant = new Merchant();
                merchant.setMerchantID(resultSet.getInt("MerchantID"));
                merchant.setMerchantName(resultSet.getString("merchantName"));
                merchant.setMerchantInfo(resultSet.getString("merchantInfo"));
                merchant.setMerchantAddress(resultSet.getString("merchantAddress"));
                merchant.setUserID(resultSet.getInt("userID"));
                merchants.add(merchant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return merchants;
    }

    public Merchant getMerchantById(int merchantId) {
        Merchant merchant = null;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM merchant WHERE MerchantID = ?")) {

            statement.setInt(1, merchantId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    merchant = new Merchant();
                    merchant.setMerchantID(resultSet.getInt("MerchantID"));
                    merchant.setMerchantName(resultSet.getString("merchantName"));
                    merchant.setMerchantInfo(resultSet.getString("merchantInfo"));
                    merchant.setMerchantAddress(resultSet.getString("merchantAddress"));
                    merchant.setUserID(resultSet.getInt("userID"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return merchant;
    }

    public void saveMerchant(Merchant merchant) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO merchant (merchantName, merchantInfo, merchantAddress, userID) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, merchant.getMerchantName());
            statement.setString(2, merchant.getMerchantInfo());
            statement.setString(3, merchant.getMerchantAddress());
            statement.setInt(4, merchant.getUserID());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 其他自定义方法...
}

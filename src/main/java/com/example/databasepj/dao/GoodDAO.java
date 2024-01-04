package com.example.databasepj.dao;

import com.example.databasepj.entity.FavoriteInfo;
import com.example.databasepj.entity.Good;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class GoodDAO {
    private Connection connection;

    public GoodDAO() {
        // 在构造函数中初始化数据库连接
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pj", "admin", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addGood(Good good) {
//        System.out.println(good);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO good (goodName, goodDescription, productID, merchantID, platformID, currentPrice) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, good.getGoodName());
            preparedStatement.setString(2, good.getGoodDescription());
            preparedStatement.setInt(3, good.getProductID());
            preparedStatement.setInt(4, good.getMerchantID());
            preparedStatement.setInt(5, good.getPlatformID());
            preparedStatement.setDouble(6, good.getCurrentPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String updatePrice(Good good) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM good WHERE GoodID = ?");
            preparedStatement.setInt(1, good.getGoodID());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int modified = resultSet.getInt("Modified");
            if (modified == 0) {
                preparedStatement = connection.prepareStatement("UPDATE good SET Modified = 1, CurrentPrice = ? WHERE GoodID = ?");
                preparedStatement.setDouble(1, good.getCurrentPrice());
                preparedStatement.setInt(2, good.getGoodID());
                preparedStatement.execute();
                return "success";
            }
            else {
                return "failed";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<FavoriteInfo> checkInform(Good good){
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM favoriteinfo WHERE GoodID = ? and PriceFloor >= ?");
            ps.setInt(1, good.getGoodID());
            ps.setDouble(2,good.getCurrentPrice());
            ResultSet rs = ps.executeQuery();
            List<FavoriteInfo> infos = new ArrayList<>();
            while(rs.next()) {
                FavoriteInfo info = new FavoriteInfo();
                info.setFavoriteInfoID(rs.getInt(1));
                info.setUserID(rs.getInt(2));
                info.setGoodID(rs.getInt(3));
                info.setPriceFloor(rs.getDouble(4));
                infos.add(info);
            }
            return infos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Good getGoodById(int goodID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM good WHERE GoodID = ?");
            preparedStatement.setInt(1, goodID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Good good = new Good();
                good.setGoodID(resultSet.getInt("GoodID"));
                good.setGoodName(resultSet.getString("goodName"));
                good.setGoodDescription(resultSet.getString("goodDescription"));
                good.setProductID(resultSet.getInt("productID"));
                good.setMerchantID(resultSet.getInt("merchantID"));
                good.setPlatformID(resultSet.getInt("platformID"));
                good.setCurrentPrice(resultSet.getDouble("currentPrice"));
                return good;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Good getGoodByGoodName(String goodName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM good WHERE GoodName = ?");
            preparedStatement.setString(1, goodName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Good good = new Good();
                good.setGoodID(resultSet.getInt("GoodID"));
                good.setGoodName(resultSet.getString("goodName"));
                good.setGoodDescription(resultSet.getString("goodDescription"));
                good.setMerchantID(resultSet.getInt("merchantID"));
                good.setPlatformID(resultSet.getInt("platformID"));
                good.setCurrentPrice(resultSet.getDouble("currentPrice"));
                return good;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Good> getAllGoods() {
        List<Good> goods = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM good");
            while (resultSet.next()) {
                Good good = new Good();
                good.setGoodID(resultSet.getInt("GoodID"));
                good.setGoodName(resultSet.getString("goodName"));
                good.setGoodDescription(resultSet.getString("goodDescription"));
                good.setMerchantID(resultSet.getInt("merchantID"));
                good.setPlatformID(resultSet.getInt("platformID"));
                good.setCurrentPrice(resultSet.getDouble("currentPrice"));
                goods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    public List<Good> getGoodsByProductID(int productID) {
        List<Good> goods = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM good WHERE ProductID = ?");
            preparedStatement.setInt(1, productID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Good good = new Good();
                good.setGoodID(resultSet.getInt("GoodID"));
                good.setGoodName(resultSet.getString("goodName"));
                good.setGoodDescription(resultSet.getString("goodDescription"));
                good.setMerchantID(resultSet.getInt("merchantID"));
                good.setPlatformID(resultSet.getInt("platformID"));
                good.setCurrentPrice(resultSet.getDouble("currentPrice"));
                goods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    public void updateGood(Good good) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE good SET goodName = ?, goodDescription = ?, merchantID = ?, platformID = ?, currentPrice = ? WHERE GoodID = ?");
            preparedStatement.setString(1, good.getGoodName());
            preparedStatement.setString(2, good.getGoodDescription());
            preparedStatement.setInt(3, good.getMerchantID());
            preparedStatement.setInt(4, good.getPlatformID());
            preparedStatement.setDouble(5, good.getCurrentPrice());
            preparedStatement.setInt(6, good.getGoodID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGood(int goodID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM good WHERE GoodID = ?");
            preparedStatement.setInt(1, goodID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

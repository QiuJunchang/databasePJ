package com.example.databasepj.dao;

import com.example.databasepj.entity.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addUser(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO user (Username) VALUES (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.executeUpdate();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    public void updateUser(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            String sql = "UPDATE user SET Username = ? WHERE UserID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setInt(2, user.getUserID());
            stmt.executeUpdate();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    public void deleteUser(int userID) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            String sql = "DELETE FROM user WHERE UserID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userID);
            stmt.executeUpdate();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM user";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                // 设置其他属性...
                users.add(user);
            }
        } finally {
            closeResources(conn, stmt, rs);
        }

        return users;
    }

    public User getUserByID(int userID) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM user WHERE UserID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userID);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                // 设置其他属性...
            }
        } finally {
            closeResources(conn, stmt, rs);
        }

        return user;
    }

    public User getUserByUsername(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM user WHERE Username = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                // 设置其他属性...
            }
        } finally {
            closeResources(conn, stmt, rs);
        }

        return user;
    }

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

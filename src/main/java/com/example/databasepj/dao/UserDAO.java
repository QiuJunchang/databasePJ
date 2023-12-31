package com.example.databasepj.dao;

import com.example.databasepj.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void addUser(User user) throws SQLException;

    void updateUser(User user) throws SQLException;

    void deleteUser(int userID) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    User getUserByID(int userID) throws SQLException;
}

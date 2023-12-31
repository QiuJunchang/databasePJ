package com.example.databasepj.service;

import com.example.databasepj.dao.UserDAO;
import com.example.databasepj.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) throws SQLException {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) throws SQLException {
        return userDAO.getUserByUsername(username);
    }

//    public User get(String username, String password){
//        return userDAO.getByUsernameAndPassword(username, password);
//    }

//    public User getByTelephone(String telephone) { return userDAO.findByTelephone(telephone);}

//    public User getByIdentity(String identity) { return userDAO.findByIdnumber(identity);}

//    public User getById(int id) {return  userDAO.findById(id);}

//    public User getByEmail(String email) { return userDAO.findByEmail(email);}

//    public void add(User user) {
//        userDAO.save(user);
//    }

//    public void update(User user) { userDAO.save(user);}
}

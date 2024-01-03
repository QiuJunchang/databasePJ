package com.example.databasepj.service;

import com.example.databasepj.dao.GoodDAO;
import com.example.databasepj.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    @Autowired
    private GoodDAO goodDAO;

    public GoodService() {
        goodDAO = new GoodDAO();
    }

    public void addGood(Good good) {
        goodDAO.addGood(good);
    }

    public String updatePrice(Good good) {
        return goodDAO.updatePrice(good);
    }

    public Good getGoodById(int goodID) {
        return goodDAO.getGoodById(goodID);
    }

    public Good getGoodByGoodName(String goodName) {
        return goodDAO.getGoodByGoodName(goodName);
    }

    public List<Good> getAllGoods() {
        return goodDAO.getAllGoods();
    }

    public List<Good> getGoodsByProductID(int productID) {return goodDAO.getGoodsByProductID(productID);}

    public void updateGood(Good good) {
        goodDAO.updateGood(good);
    }

    public void deleteGood(int goodID) {
        goodDAO.deleteGood(goodID);
    }
}

package com.example.databasepj.service;

import com.example.databasepj.dao.GoodDAO;
import com.example.databasepj.entity.Good;
import com.example.databasepj.tools.Result;
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

    public Result updatePrice(Good good) {
        return new Result(goodDAO.updatePrice(good), goodDAO.checkInform(good).size(), goodDAO.checkInform(good));
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

package com.example.databasepj.controller.user;

import com.example.databasepj.entity.FavoriteInfo;
import com.example.databasepj.entity.Good;
import com.example.databasepj.service.FavoriteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FavoriteInfoController {
    @Autowired
    FavoriteInfoService favoriteInfoService;

    @CrossOrigin
    @RequestMapping(value = "api/addFavorite")
    @ResponseBody
    public String addFavorite(@RequestBody FavoriteInfo requestFavorite) {
        int userID = requestFavorite.getUserID();
        int goodID = requestFavorite.getGoodID();
        double priceFloor = requestFavorite.getPriceFloor();
        FavoriteInfo favoriteInfo = new FavoriteInfo();
        favoriteInfo.setUserID(userID);
        favoriteInfo.setGoodID(goodID);
        favoriteInfo.setPriceFloor(priceFloor);
        favoriteInfoService.addFavoriteInfo(favoriteInfo);
        return "success";
    }
}

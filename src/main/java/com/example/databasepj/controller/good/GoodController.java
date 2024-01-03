package com.example.databasepj.controller.good;

import com.example.databasepj.entity.Good;
import com.example.databasepj.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodController {
    @Autowired
    GoodService goodService;

    @CrossOrigin
    @RequestMapping(value = "api/queryGood")
    @ResponseBody
    public Good queryGood(@RequestBody Good requestGood) {
        String goodname = requestGood.getGoodName();
        return goodService.getGoodByGoodName(goodname);
    }


    @CrossOrigin
    @RequestMapping(value = "api/addGood")
    @ResponseBody
    public String addGood(@RequestBody Good requstGood) {
        String goodName = requstGood.getGoodName();
        String goodDescription = requstGood.getGoodDescription();
        int productID = requstGood.getProductID();
        int merchantID = requstGood.getMerchantID();
        int platformID = requstGood.getPlatformID();
        double currentPrice = requstGood.getCurrentPrice();
        Good good = new Good();
        good.setGoodName(goodName);
        good.setGoodDescription(goodDescription);
        good.setProductID(productID);
        good.setMerchantID(merchantID);
        good.setPlatformID(platformID);
        good.setCurrentPrice(currentPrice);
        goodService.addGood(good);
        return "success";
    }
}

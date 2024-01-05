package com.example.databasepj.controller.good;

import com.example.databasepj.entity.Good;
import com.example.databasepj.entity.Product;
import com.example.databasepj.service.GoodService;
import com.example.databasepj.service.ProductService;
import com.example.databasepj.tools.GoodProduct;
import com.example.databasepj.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodController {
    @Autowired
    GoodService goodService;

    @Autowired
    ProductService productService;

    @CrossOrigin
    @RequestMapping(value = "api/queryGood")
    @ResponseBody
    public Good queryGood(@RequestBody Good requestGood) {
        String goodname = requestGood.getGoodName();
        return goodService.getGoodByGoodName(goodname);
    }

    @CrossOrigin
    @RequestMapping(value = "api/queryGoodWithDetail")
    @ResponseBody
    public GoodProduct queryGoodWithDetail(@RequestBody Map<String, Integer> param){
        int goodID = param.get("goodID");
        int productID = param.get("productID");
        return new GoodProduct(goodService.getGoodById(goodID), productService.getProductById(productID));
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

    @CrossOrigin
    @RequestMapping(value = "api/updatePrice")
    @ResponseBody
    public Result updatePrice(@RequestBody Good requstGood){
        int goodID = requstGood.getGoodID();
        double newPrice = requstGood.getCurrentPrice();
        Good good = new Good();
        good.setGoodID(goodID);
        good.setCurrentPrice(newPrice);
        return goodService.updatePrice(good);
    }


}

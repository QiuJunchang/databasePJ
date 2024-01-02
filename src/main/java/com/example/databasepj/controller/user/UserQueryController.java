package com.example.databasepj.controller.user;

import com.example.databasepj.entity.Good;
import com.example.databasepj.entity.ProductPriceInfo;
import com.example.databasepj.service.GoodService;
import com.example.databasepj.service.ProductService;
import com.example.databasepj.service.ProductPriceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserQueryController {
    @Autowired
    GoodService goodService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductPriceInfoService productPriceInfoService;

    @CrossOrigin
    @RequestMapping(value = "api/getAllGoods")
    @ResponseBody
    public List<Good> getAllGoods() {
        return goodService.getAllGoods();
    }

    @CrossOrigin
    @RequestMapping(value = "api/getGoodsWithProductName")
    @ResponseBody
    public List<Good> getGoodsWithProductName(@RequestBody String productName) {
        int productID = productService.getProductByName(productName).getProductID();
        return goodService.getGoodsByProductID(productID);
    }

    @CrossOrigin
    @RequestMapping(value = "api/getPriceInfoByGoodID")
    @ResponseBody
    public List<ProductPriceInfo> getPriceInfoByGoodID(@RequestBody int goodID) {
        return productPriceInfoService.getPriceInfoByGoodID(goodID);
    }
}

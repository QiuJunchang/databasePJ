package com.example.databasepj.controller.user;

import com.example.databasepj.entity.Good;
import com.example.databasepj.entity.ProductPriceInfo;
import com.example.databasepj.service.GoodService;
import com.example.databasepj.service.ProductService;
import com.example.databasepj.service.ProductPriceInfoService;
import com.example.databasepj.tools.ProductPriceInfoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserQueryController {
    @Autowired
    GoodService goodService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductPriceInfoService productPriceInfoService;

    ProductPriceInfoFilter productPriceInfoFilter = new ProductPriceInfoFilter();

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

    @CrossOrigin
    @RequestMapping(value = "api/getPriceInfoWithDate")
    @ResponseBody
    public List<ProductPriceInfo> queryGoodWithDate(@RequestBody Map<String, Integer> param) {
        int goodID = param.get("goodID");
        int mode = param.get("dateMode");
        List<ProductPriceInfo> products = productPriceInfoService.getPriceInfoByGoodID(goodID);
        if (mode == 0) return productPriceInfoFilter.filterByLast7Days(products);
        else if (mode == 1) return productPriceInfoFilter.filterByLast30Days(products);
        else if (mode == 2) return productPriceInfoFilter.filterByLastYear(products);
        else return null;
    }
}

package com.example.databasepj.controller.product;

import com.example.databasepj.service.ProductPriceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
public class ProductPriceInfoController {
    @Autowired
    ProductPriceInfoService productPriceInfoService;

    @CrossOrigin
    @RequestMapping(value = "api/SavePrice")
    @ResponseBody
    public String SavePrice(@RequestBody Date date) {
        productPriceInfoService.saveProductPriceInfo(date);
        return "success";
    }
}

package com.example.databasepj.controller.product;

import com.example.databasepj.service.ProductPriceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductPriceInfo {
    @Autowired
    ProductPriceInfoService productPriceInfoService;
}

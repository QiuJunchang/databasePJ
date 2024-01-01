package com.example.databasepj.controller.product;

import com.example.databasepj.entity.Product;
import com.example.databasepj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @CrossOrigin
    @RequestMapping(value = "api/addProduct")
    @ResponseBody
    public String addProduct(@RequestBody Product requstProduct) {
        String productName = requstProduct.getProductName();
        String productCategory = requstProduct.getProductCategory();
        String productOrigin = requstProduct.getProductOrigin();
        Date productionDate = requstProduct.getProductionDate();
        int shelfLife = requstProduct.getShelfLife();
        Product product = new Product();
        product.setProductName(productName);
        product.setProductCategory(productCategory);
        product.setProductOrigin(productOrigin);
        product.setProductionDate(productionDate);
        product.setShelfLife(shelfLife);
        productService.addProduct(product);
        return "success";
    }
}

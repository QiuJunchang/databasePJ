package com.example.databasepj.controller.product;

import com.example.databasepj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
}

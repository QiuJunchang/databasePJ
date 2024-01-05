package com.example.databasepj.tools;

import com.example.databasepj.entity.Good;
import com.example.databasepj.entity.Product;

public class GoodProduct {
    public Good good;
    public Product product;

    public GoodProduct(Good good, Product product){
        this.good = good;
        this.product = product;
    }
}

package com.example.databasepj.tools;

import com.example.databasepj.entity.ProductPriceInfo;

import java.util.List;

public class Result {
    public String message;
    public List<ProductPriceInfo> productPriceInfoList;

    public Result(String message, List<ProductPriceInfo> productPriceInfoList){
        this.message = message;
        this.productPriceInfoList = productPriceInfoList;
    }

}

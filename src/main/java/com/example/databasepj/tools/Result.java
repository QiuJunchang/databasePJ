package com.example.databasepj.tools;

import com.example.databasepj.entity.FavoriteInfo;
import com.example.databasepj.entity.ProductPriceInfo;

import java.util.List;

public class Result {
    public String message;
    public List<ProductPriceInfo> productPriceInfoList;
    public int num;
    public List<FavoriteInfo> favoriteInfos;

    public Result(String message, List<ProductPriceInfo> productPriceInfoList){
        this.message = message;
        this.productPriceInfoList = productPriceInfoList;
    }

    public Result(String message, int num, List<FavoriteInfo> favoriteInfos){
        this.message = message;
        this.num = num;
        this.favoriteInfos = favoriteInfos;
    }

}

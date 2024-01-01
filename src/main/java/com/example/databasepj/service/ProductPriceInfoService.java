package com.example.databasepj.service;

import com.example.databasepj.dao.ProductPriceInfoDAO;
import com.example.databasepj.entity.ProductPriceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class ProductPriceInfoService {
    @Autowired
    private ProductPriceInfoDAO productPriceInfoDAO;

    public void saveProductPriceInfo(Date date){
        productPriceInfoDAO.saveProductPriceInfo(date);
    }

    // 其他自定义方法...
}

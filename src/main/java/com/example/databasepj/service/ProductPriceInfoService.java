package com.example.databasepj.service;

import com.example.databasepj.dao.ProductPriceInfoDAO;
import com.example.databasepj.entity.ProductPriceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductPriceInfoService {
    @Autowired
    private ProductPriceInfoDAO productPriceInfoDAO;

    public List<ProductPriceInfo> getAllProductPriceInfo() {
        return productPriceInfoDAO.getAllProductPriceInfo();
    }

    public ProductPriceInfo getProductPriceInfoById(int productPriceInfoId) {
        return productPriceInfoDAO.getProductPriceInfoById(productPriceInfoId);
    }

    public void saveProductPriceInfo(ProductPriceInfo productPriceInfo) {
        productPriceInfoDAO.saveProductPriceInfo(productPriceInfo);
    }

    // 其他自定义方法...
}

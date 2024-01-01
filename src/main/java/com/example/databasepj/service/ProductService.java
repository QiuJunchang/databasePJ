package com.example.databasepj.service;

import com.example.databasepj.dao.ProductDAO;
import com.example.databasepj.entity.Good;
import com.example.databasepj.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        productDAO =  new ProductDAO();
    }

    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productDAO.getProductById(productId);
    }

    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    // 其他自定义方法...
}

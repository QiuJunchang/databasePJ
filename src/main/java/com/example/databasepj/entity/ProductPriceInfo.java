package com.example.databasepj.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "productpriceinfo")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ProductPriceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductPriceInfoID")
    private int productPriceInfoID;
    private int goodID;
    private Date priceDate;
    private double historicalPrice;

    public int getProductPriceInfoID() {
        return productPriceInfoID;
    }

    public void setProductPriceInfoID(int productPriceInfoID) {
        this.productPriceInfoID = productPriceInfoID;
    }

    public int getGoodID() {
        return goodID;
    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public double getHistoricalPrice() {
        return historicalPrice;
    }

    public void setHistoricalPrice(double historicalPrice) {
        this.historicalPrice = historicalPrice;
    }
}

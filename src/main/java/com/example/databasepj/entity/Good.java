package com.example.databasepj.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "good")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GoodID")
    private int goodID;
    private String goodName;
    private String goodDescription;
    private int merchantID;
    private int platformID;
    private double currentPrice;

    public int getGoodID() {
        return goodID;
    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    public int getMerchantID(){
        return merchantID;
    }

    public void setMerchantID(int merchantID){
        this.merchantID = merchantID;
    }

    public  int getPlatformID(){
        return platformID;
    }

    public void setPlatformID(int platformID){
        this.platformID = platformID;
    }

    public double getCurrentPrice(){
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice){
        this.currentPrice = currentPrice;
    }
}

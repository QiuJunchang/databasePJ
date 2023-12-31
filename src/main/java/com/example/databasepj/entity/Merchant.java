package com.example.databasepj.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "merchant")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MerchantID")
    private int merchantID;
    private String merchantName;
    private String merchantInfo;
    private String merchantAddress;
    private int userID;

    public int getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(int merchantID) {
        this.merchantID = merchantID;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(String merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}


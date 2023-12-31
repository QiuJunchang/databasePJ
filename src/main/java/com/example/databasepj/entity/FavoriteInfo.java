package com.example.databasepj.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "favoriteinfo")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class FavoriteInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteInfoID")
    private int favoriteInfoID;
    private int userID;
    private int goodID;
    private double priceFloor;

    public int getFavoriteInfoID() {
        return favoriteInfoID;
    }

    public void setFavoriteInfoID(int favoriteInfoID) {
        this.favoriteInfoID = favoriteInfoID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getGoodID() {
        return goodID;
    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public double getPriceFloor() {
        return priceFloor;
    }

    public void setPriceFloor(double priceFloor) {
        this.priceFloor = priceFloor;
    }
}

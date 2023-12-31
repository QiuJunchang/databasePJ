package com.example.databasepj.service;

import com.example.databasepj.dao.FavoriteInfoDAO;
import com.example.databasepj.entity.FavoriteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteInfoService {
    @Autowired
    private FavoriteInfoDAO favoriteInfoDAO;

    public void addFavoriteInfo(FavoriteInfo favoriteInfo){
        favoriteInfoDAO.addFavoriteInfo(favoriteInfo);
    }

    // 其他自定义方法...
}

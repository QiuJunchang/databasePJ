package com.example.databasepj.controller.user;

import com.example.databasepj.service.FavoriteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FavoriteInfoController {
    @Autowired
    FavoriteInfoService favoriteInfoService;
}

package com.example.databasepj.controller.good;

import com.example.databasepj.entity.Good;
import com.example.databasepj.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodController {
    @Autowired
    GoodService goodService;

    @CrossOrigin
    @RequestMapping(value = "api/queryGood")
    @ResponseBody
    public Good queryGood(@RequestBody Good requestGood) {
        String goodname = requestGood.getGoodName();
        return goodService.getGoodByGoodName(goodname);
    }
}

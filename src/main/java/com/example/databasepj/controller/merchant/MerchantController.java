package com.example.databasepj.controller.merchant;

import com.example.databasepj.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MerchantController {
    @Autowired
    MerchantService merchantService;
}

package com.example.databasepj.controller.platform;

import com.example.databasepj.entity.Platform;
import com.example.databasepj.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PlatformController {
    @Autowired
    PlatformService platformService;
}

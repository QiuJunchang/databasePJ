package com.example.databasepj.service;

import com.example.databasepj.dao.PlatformDAO;
import com.example.databasepj.entity.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {
    @Autowired
    private PlatformDAO platformDAO;

    public PlatformService(PlatformDAO platformDAO) {
        this.platformDAO = platformDAO;
    }

    public List<Platform> getAllPlatforms() {
        return platformDAO.getAllPlatforms();
    }

    public Platform getPlatformById(int platformId) {
        return platformDAO.getPlatformById(platformId);
    }

    public void savePlatform(Platform platform) {
        platformDAO.savePlatform(platform);
    }

    // 其他自定义方法...
}

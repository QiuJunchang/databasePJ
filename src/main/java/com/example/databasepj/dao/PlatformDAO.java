package com.example.databasepj.dao;

import com.example.databasepj.entity.Platform;

import java.sql.SQLException;
import java.util.List;

public interface PlatformDAO {
    void addPlatform(Platform platform) throws SQLException;

    void updatePlatform(Platform platform) throws SQLException;

    void deletePlatform(int platformID) throws SQLException;

    List<Platform> getAllPlatforms() throws SQLException;

    Platform getPlatformByID(int platformID) throws SQLException;
}

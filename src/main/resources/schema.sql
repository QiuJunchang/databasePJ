
DROP TABLE IF EXISTS Platform;
CREATE TABLE Platform (
                          PlatformID INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                          PlatformName VARCHAR(255) NOT NULL,
                          PRIMARY KEY (PlatformID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

# INSERT INTO `Platform` VALUES ('1', 'admin');
-- 用户表
DROP TABLE IF EXISTS User;
CREATE TABLE User (
                      UserID INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                      Username VARCHAR(255) NOT NULL,
                      RealName VARCHAR(255) DEFAULT NULL,
                      Age INT DEFAULT NULL,
                      Gender VARCHAR(10) DEFAULT NULL,
                      Phone VARCHAR(15) DEFAULT NULL,
                      PRIMARY KEY (UserID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 商家表
DROP TABLE IF EXISTS Merchant;
CREATE TABLE Merchant (
                          MerchantID INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                          MerchantName VARCHAR(255) NOT NULL,
                          MerchantInfo VARCHAR(255) NOT NULL,
                          MerchantAddress VARCHAR(255) NOT NULL,
                          UserID INT NOT NULL,
                          PRIMARY KEY (MerchantID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 商品表
DROP TABLE IF EXISTS Product;
CREATE TABLE Product (
                         ProductID INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                         ProductName VARCHAR(255) NOT NULL,
                         ProductCategory VARCHAR(255) NOT NULL,
                         ProductOrigin VARCHAR(255) NOT NULL,
                         ProductionDate DATE NOT NULL,
                         ShelfLife INT NOT NULL,
                         PRIMARY KEY (ProductID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 发布商品表
DROP TABLE IF EXISTS Good;
CREATE TABLE Good (
                         GoodID INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                         GoodName VARCHAR(255) NOT NULL,
                         GoodDescription VARCHAR(255) NOT NULL,
                         ProductID INT NOT NULL,
                         MerchantID INT NOT NULL,
                         PlatformID INT NOT NULL,
                         CurrentPrice DECIMAL(10, 2) NOT NULL,
                         PRIMARY KEY (GoodID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 商品价格信息表
DROP TABLE IF EXISTS ProductPriceInfo;
CREATE TABLE ProductPriceInfo (
                                  ProductPriceInfoID INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                                  GoodID INT NOT NULL,
                                  PriceDate DATE NOT NULL,
                                  HistoricalPrice DECIMAL(10, 2) NOT NULL,
                                  PRIMARY KEY (ProductPriceInfoID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 收藏信息表
DROP TABLE IF EXISTS FavoriteInfo;
CREATE TABLE FavoriteInfo (
                              FavoriteInfoID INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                              UserID INT NOT NULL,
                              GoodID INT NOT NULL,
                              PriceFloor DECIMAL(10, 2) NOT NULL,
                              PRIMARY KEY (FavoriteInfoID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

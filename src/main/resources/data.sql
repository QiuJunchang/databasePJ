INSERT INTO `user`(`UserID`, `Username`, `RealName`, `Age`, `Gender`, `Phone`)
VALUES
    ('1', 'qjc', '邱军昌', '23', 'male', '18753441003'),
    ('2', 'llx', '吕乐翔', '25', 'male', '1234567890'),
    ('3', 'user3', 'RealName3', '30', 'male', '9876543210'),
    ('4', 'user4', 'RealName4', '40', 'female', '5555555555');

INSERT INTO Merchant (MerchantName, MerchantInfo, MerchantAddress, UserID)
VALUES
    ('Bob 的 Store', '鲍勃的商店', '某个地址', 1),
    ('Joy 的 Boutique', '乔伊的精品店', '另一个地址', 2),
    ('Supermart', '超级市场', '某个城市', 3);

INSERT INTO Product (ProductName, ProductCategory, ProductOrigin, ProductionDate, ShelfLife)
VALUES
    ('苹果', '水果', '中国', '2023-01-01', 7),
    ('橙子', '水果', '中国', '2023-01-01', 7),
    ('牛奶', '乳制品', '国内', '2023-01-01', 14),
    ('酸奶', '乳制品', '国内', '2023-01-01', 14),
    ('面包', '烘焙食品', '本地', '2023-01-01', 5),
    ('蛋糕', '烘焙食品', '本地', '2023-01-01', 5);

-- 商家1的默认数据
-- 商家1的商品数据
INSERT INTO Good (GoodName, GoodDescription, MerchantID, PlatformID, CurrentPrice, ProductID)
VALUES
    ('苹果', '新鲜水果', 1, 1, 2.99, 1),
    ('橙子', '甜美橙子', 1, 1, 1.99, 2);

-- 商家2的商品数据
INSERT INTO Good (GoodName, GoodDescription, MerchantID, PlatformID, CurrentPrice, ProductID)
VALUES
    ('苹果', '新鲜水果', 2, 1, 3.49, 1),
    ('牛奶', '纯牛奶', 2, 1, 3.49, 3);

-- 商家3的商品数据
INSERT INTO Good (GoodName, GoodDescription, MerchantID, PlatformID, CurrentPrice, ProductID)
VALUES
    ('橙子', '甜美橙子', 3, 1, 1.99, 2),
    ('面包', '香软面包', 3, 1, 1.99, 5),
    ('酸奶', '乳制品', 3, 1, 3.99, 4);

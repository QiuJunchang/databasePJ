package com.example.databasepj.tools;

import com.example.databasepj.entity.ProductPriceInfo;

import java.time.LocalDate;
import java.sql.Date;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ProductPriceInfoFilter {
    public List<ProductPriceInfo> filterByLast7Days(List<ProductPriceInfo> ProductPriceInfos) {
        List<ProductPriceInfo> filteredList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysAgo = today.minusDays(7);

        for (ProductPriceInfo productPriceInfo : ProductPriceInfos) {
            LocalDate productDate = productPriceInfo.getPriceDate().toLocalDate();
            if (productDate.isAfter(sevenDaysAgo) || productDate.isEqual(sevenDaysAgo)) {
                filteredList.add(productPriceInfo);
            }
        }

        return filteredList;
    }

    public List<ProductPriceInfo> filterByLast30Days(List<ProductPriceInfo> ProductPriceInfos) {
        List<ProductPriceInfo> filteredList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysAgo = today.minusDays(30);

        for (ProductPriceInfo productPriceInfo : ProductPriceInfos) {
            LocalDate productDate = productPriceInfo.getPriceDate().toLocalDate();
            if (productDate.isAfter(thirtyDaysAgo) || productDate.isEqual(thirtyDaysAgo)) {
                filteredList.add(productPriceInfo);
            }
        }

        return filteredList;
    }

    public List<ProductPriceInfo> filterByLastYear(List<ProductPriceInfo> ProductPriceInfos) {
        List<ProductPriceInfo> filteredList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate oneYearAgo = today.minusYears(1);

        for (ProductPriceInfo productPriceInfo : ProductPriceInfos) {
            LocalDate productDate = productPriceInfo.getPriceDate().toLocalDate();
            if (productDate.isAfter(oneYearAgo) || productDate.isEqual(oneYearAgo)) {
                filteredList.add(productPriceInfo);
            }
        }

        return filteredList;
    }
}

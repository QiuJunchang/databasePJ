package com.example.databasepj.service;

import com.example.databasepj.dao.MerchantDAO;
import com.example.databasepj.entity.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MerchantService {
    @Autowired
    private MerchantDAO merchantDAO;

    public MerchantService(MerchantDAO merchantDAO) {
        this.merchantDAO = merchantDAO;
    }

    public List<Merchant> getAllMerchants() {
        return merchantDAO.getAllMerchants();
    }

    public Merchant getMerchantById(int merchantId) {
        return merchantDAO.getMerchantById(merchantId);
    }

    public void saveMerchant(Merchant merchant) {
        merchantDAO.saveMerchant(merchant);
    }

    // 其他自定义方法...
}

package com.example.swp_jewelryproductionordersystem.services.interfaces;

import com.example.swp_jewelryproductionordersystem.entities.Accounts;

import java.util.List;

public interface AccountService {
    List<Accounts> getAllAccounts();
    Accounts getAccountById(int id);
    Accounts saveOrUpdateAccount(Accounts account);
    void deleteAccount(int id);
    Accounts authenticate(String email, String password);
}

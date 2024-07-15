package com.example.swp_jewelryproductionordersystem.services;

import com.example.swp_jewelryproductionordersystem.entities.Accounts;
import com.example.swp_jewelryproductionordersystem.repositories.AccountRepository;
import com.example.swp_jewelryproductionordersystem.services.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Accounts> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Accounts getAccountById(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Accounts saveOrUpdateAccount(Accounts account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Accounts authenticate(String email, String password) {
        System.out.println(password);
        Accounts account = accountRepository.findByEmail(email);
        if (account != null && password.equals(account.getPassword())) {
            return account;
        }
        return null;
    }
}

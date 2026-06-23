package com.demo.transactions.service;


import com.demo.transactions.repo.AccountRepo;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepo repo;
    
    public AccountService(AccountRepo repo) {
        this.repo = repo;
    }
    
    
}

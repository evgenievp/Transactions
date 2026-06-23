package com.demo.transactions.service;


import com.demo.transactions.dtos.BalanceResponse;
import com.demo.transactions.entities.Account;
import com.demo.transactions.repo.AccountRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepo repo;
    
    public AccountService(AccountRepo repo) {
        this.repo = repo;
    }

    public BalanceResponse getBalance(Long accountId) {
        Account account = repo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return new BalanceResponse(
                account.getId(),
                account.getBalance()
        );
    }

    public Account findById(long id) {
        Optional<Account> res = this.repo.findById(id);
        if (res.isEmpty()) {
            throw new EntityNotFoundException("no such account");
        }
        return res.get();
    }



}

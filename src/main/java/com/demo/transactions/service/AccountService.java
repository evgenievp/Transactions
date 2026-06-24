package com.demo.transactions.service;


import com.demo.transactions.dtos.AccountDto;
import com.demo.transactions.dtos.BalanceResponse;
import com.demo.transactions.dtos.CreateAccountRequest;
import com.demo.transactions.entities.Account;
import com.demo.transactions.entities.User;
import com.demo.transactions.repo.AccountRepo;
import com.demo.transactions.repo.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepo repo;
    private final UserRepo userRepo;
    
    public AccountService(AccountRepo repo, UserRepo userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
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


    public List<AccountDto> getAllAccounts() {
        List<Account> res = this.repo.findAll();
        LinkedList<AccountDto> output = new LinkedList<>();
        for (var r : res) {
            output.add(mapAccountToDto(r));
        }
        return output;
    }

    public AccountDto findDtoById(long id) {
        Optional<Account> result = this.repo.findById(id);

        if (result.isPresent()) {
            return mapAccountToDto(result.get());
        }
        throw new EntityNotFoundException("No account with this id");

    }

    public AccountDto mapAccountToDto(Account account) {
        return new AccountDto(account.getIban(),
                account.getBalance(),
                account.getUser());
    }

    public void createAccount(Long userId, CreateAccountRequest request) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = new Account();
        account.setIban(request.getIban());
        account.setBalance(request.getInitialBalance());
        account.setUser(user);
        repo.save(account);
    }
}

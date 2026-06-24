package com.demo.transactions.controller;

import com.demo.transactions.dtos.AccountDto;
import com.demo.transactions.dtos.BalanceResponse;
import com.demo.transactions.dtos.CreateAccountRequest;
import com.demo.transactions.dtos.UserDto;
import com.demo.transactions.entities.Account;
import com.demo.transactions.service.AccountService;
import com.demo.transactions.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final AccountService service;
    private final UserService userService;

    public AccountController(AccountService service,
                                UserService userService) {
        this.userService = userService;
        this.service = service;
    }


    @PostMapping("/{id}/deposit/{amount}")
    public ResponseEntity<BalanceResponse> deposit(@PathVariable long id,
                                                   @PathVariable BigDecimal amount) {
        Account account = this.service.findById(id);
        service.deposit(id, amount);
        return ResponseEntity.status(200).body(new BalanceResponse(id, amount));
    }

    @PostMapping("/{id}/withdraw/{amount}")
    public ResponseEntity<BalanceResponse> withdraw(@PathVariable long id,
                                                    @PathVariable BigDecimal amount) {
        Account account = this.service.findById(id);
        service.withdraw(id, amount);
        return ResponseEntity.status(200).body(new BalanceResponse(id, amount));
    }

    @PostMapping("/users/{userId}/accounts")
    public ResponseEntity<String> createAccount(@PathVariable Long userId,
                                                @RequestBody CreateAccountRequest request) {
        service.createAccount(userId, request);
        return ResponseEntity.status(201).body("Account created");
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BalanceResponse> getBalance(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBalance(id));
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAll() {
        return ResponseEntity.status(200).body(this.service.getAllAccounts());
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDto> getById(@PathVariable long id) {
        return ResponseEntity.status(200).body(this.service.findDtoById(id));
    }




}

package com.demo.transactions.controller;

import com.demo.transactions.dtos.BalanceResponse;
import com.demo.transactions.entities.Account;
import com.demo.transactions.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BalanceResponse> getBalance(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBalance(id));
    }

    @PostMapping("/{id}/deposit/{amount}")
    public ResponseEntity<BalanceResponse> deposit(@PathVariable long id,
                                                   @PathVariable BigDecimal amount) {
        Account account = this.service.findById(id);
        account.deposit(amount);
        return ResponseEntity.status(200).body(new BalanceResponse(id, amount));
    }

    @PostMapping("/{id}/withdraw/{amount}")
    public ResponseEntity<BalanceResponse> withdraw(@PathVariable long id,
                                                    @PathVariable BigDecimal amount) {
        Account account = this.service.findById(id);
        account.withdraw(amount);
        return ResponseEntity.status(200).body(new BalanceResponse(id, amount));
    }





}

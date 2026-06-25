package com.demo.transactions.controller;

import com.demo.transactions.dtos.TransferRequest;
import com.demo.transactions.dtos.TransferResponse;
import com.demo.transactions.repo.AccountRepo;
import com.demo.transactions.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class TransferController {
    private final TransferService service;
    private final AccountRepo accountRepo;

    public TransferController(TransferService service,
                              AccountRepo accountRepo) {
        this.service = service;
        this.accountRepo = accountRepo;
    }

    @PostMapping("/transfer/{from}/{to}/{amount}")
    public ResponseEntity<TransferResponse> transfer(@PathVariable long from,
                                                     @PathVariable long to,
                                                     @PathVariable BigDecimal amount) {
        TransferRequest request = new TransferRequest();
        request.setFromAccountId(from);
        request.setToAccountId(to);
        request.setAmount(amount);
        TransferResponse response = service.transfer(request);
        return ResponseEntity.status(201).body(response);
    }




}


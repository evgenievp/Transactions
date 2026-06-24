package com.demo.transactions.controller;

import com.demo.transactions.service.TransferService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }




}


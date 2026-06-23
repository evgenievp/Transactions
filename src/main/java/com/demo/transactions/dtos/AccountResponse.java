package com.demo.transactions.dtos;


import java.math.BigDecimal;

public class AccountResponse {

    private Long id;
    private String iban;
    private BigDecimal balance;
    private String ownerUsername;

    public AccountResponse() {
    }

    public AccountResponse(Long id,
                           String iban,
                           BigDecimal balance,
                           String ownerUsername) {
        this.id = id;
        this.iban = iban;
        this.balance = balance;
        this.ownerUsername = ownerUsername;
    }

    public Long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }
}

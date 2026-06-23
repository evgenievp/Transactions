package com.demo.transactions.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class CreateAccountRequest {

    @NotNull
    private Long userId;

    @NotBlank
    private String iban;

    @PositiveOrZero
    private BigDecimal initialBalance;

    public CreateAccountRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public String getIban() {
        return iban;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }
}
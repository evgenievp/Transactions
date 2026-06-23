package com.demo.transactions.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransferRequest {

    @NotNull
    private long fromAccountId;

    @NotNull
    private long toAccountId;

    @NotNull
    @Positive
    private BigDecimal amount;

    private boolean failAfterWithdraw;

    public TransferRequest() {
    }

    public long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isFailAfterWithdraw() {
        return failAfterWithdraw;
    }

    public void setFailAfterWithdraw(boolean failAfterWithdraw) {
        this.failAfterWithdraw = failAfterWithdraw;
    }
}
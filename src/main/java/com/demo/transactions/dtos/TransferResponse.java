package com.demo.transactions.dtos;

import java.math.BigDecimal;

public class TransferResponse {

    private Long transferId;
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
    private String status;


    public TransferResponse(Long transferId,
                            Long fromAccountId,
                            Long toAccountId,
                            BigDecimal amount,
                            String status) {
        this.transferId = transferId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.status = status;
    }

    public Long getTransferId() {
        return transferId;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
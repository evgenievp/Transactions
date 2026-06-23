package com.demo.transactions.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TransferDto {
    private Long fromAccountId;
    private Long toAccountId;
    private double amount;
    private String status;
    private LocalDateTime createdAt;

}

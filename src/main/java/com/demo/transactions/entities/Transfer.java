package com.demo.transactions.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
    private String status;
    private LocalDateTime createdAt;


    public Transfer(Long fromAccountId, Long toAccountId,
                    BigDecimal amount,
                    String status,
                    LocalDateTime createdAt) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Transfer(Long fromAccountId,
                    Long toAccountId,
                    BigDecimal amount,
                    String status) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }
}

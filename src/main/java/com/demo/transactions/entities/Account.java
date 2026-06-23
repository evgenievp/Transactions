package com.demo.transactions.entities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban;
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account(String iban, BigDecimal balance, User user) {
        this.iban = iban;
        this.balance = balance;
        this.user = user;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        this.balance = this.balance.subtract(amount);
    }
}

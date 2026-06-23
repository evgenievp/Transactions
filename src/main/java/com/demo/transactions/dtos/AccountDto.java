package com.demo.transactions.dtos;

import com.demo.transactions.entities.User;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@NoArgsConstructor
@Getter
@Setter
public class AccountDto {
    private String iban;
    @Min(value = 0, message = "balance can't be negative.")
    private BigDecimal balance;
    private User user;

    public AccountDto(String iban, BigDecimal balance, User user) {
        this.iban = iban;
        this.balance = balance;
        this.user = user;
    }

}

package com.demo.transactions.dtos;

import com.demo.transactions.entities.Account;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    @NotNull
    @NotBlank
    @Size(min = 5, max = 50, message = "Email must be between 8 and 50 characters.")
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 5, max = 50, message = "Email must be between 8 and 50 characters.")
    private String email;

    public UserDto(String username,
                   String email) {
        this.username = username;
        this.email = email;
    }
}

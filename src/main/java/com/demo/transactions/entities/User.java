package com.demo.transactions.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    @OneToMany
    private List<Account> accounts;

    public User(String username,
                String email,
                List<Account> accounts) {
        this.username = username;
        this.email = email;
        this.accounts = accounts;
    }

    public User(String username,
                String email) {
        this.username = username;
        this.email = email;
    }

    public User(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}

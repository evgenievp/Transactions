package com.demo.transactions.controller;

import com.demo.transactions.dtos.UserDto;
import com.demo.transactions.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto dto) {
        if (this.service.findByEmail(dto.getEmail()).isEmpty()) {
            this.service.createUser(dto);
            return ResponseEntity.status(201).body("user created");
        }
        else {
            return ResponseEntity.status(409).body("wrong username, email or password");
        }
    }



}

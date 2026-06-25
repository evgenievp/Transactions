package com.demo.transactions.dtos;

import java.time.LocalDateTime;

public class ErrorDTO {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ErrorDTO(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
package com.springboot.example.springbootdeepdive.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
public class ErrorResponse {
    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp= LocalDateTime.now();
    }

    String message;
    int status;
    LocalDateTime timestamp;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

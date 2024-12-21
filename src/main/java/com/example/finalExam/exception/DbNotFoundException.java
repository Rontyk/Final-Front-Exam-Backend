package com.example.finalExam.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DbNotFoundException extends RuntimeException {
    private String error;
    private String message;

}

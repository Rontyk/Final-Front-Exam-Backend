package com.example.finalExam.exception.advice;


import com.example.finalExam.dto.response.ErrorResponseDto;
import com.example.finalExam.exception.DbNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DbNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlePositionNotFoundException(DbNotFoundException ex) {
        log.error("DbRowNotFoundException exception: ", ex);
        ErrorResponseDto errorResponse = new ErrorResponseDto(ex.getError(), ex.getMessage(), getStackTrace(ex));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidException exception: ", ex);
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                getStackTrace(ex)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    private static String getStackTrace(Throwable ex) {
        //filter stackTrace
        filterStackTracesByProjectPackage(ex);

        //convert stackTrace to String
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);

        return sw.toString();
    }

    private static void filterStackTracesByProjectPackage(Throwable ex) {
        if (ex == null) return;

        StackTraceElement[] stackTraces = Arrays.stream(ex.getStackTrace())
                .filter(se -> se.getClassName().startsWith("com."))
                .toArray(StackTraceElement[]::new);

        ex.setStackTrace(stackTraces);
    }
}

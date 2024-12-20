package com.example.finalExam.controller;


import com.example.finalExam.dto.request.AuthRequestDto;
import com.example.finalExam.dto.request.RegisterUserRequestDto;
import com.example.finalExam.dto.response.AuthResponseDto;
import com.example.finalExam.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterUserRequestDto registerUserRequestDto){
        authService.registerUser(registerUserRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> loginUser(@Valid @RequestBody AuthRequestDto authRequestDto){
        AuthResponseDto authResponseDto = authService.authenticateUser(authRequestDto);
        return ResponseEntity.ok(authResponseDto);
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authService.refreshToken(request, response);
    }
}

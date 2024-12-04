package com.example.kzh.service;


import com.example.kzh.dto.request.AuthRequestDto;
import com.example.kzh.dto.request.RegisterUserRequestDto;
import com.example.kzh.dto.response.AuthResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {

    void registerUser(RegisterUserRequestDto user);

    AuthResponseDto authenticateUser(AuthRequestDto auth);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;


}

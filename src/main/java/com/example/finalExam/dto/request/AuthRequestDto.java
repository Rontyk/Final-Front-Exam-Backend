package com.example.finalExam.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthRequestDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
}

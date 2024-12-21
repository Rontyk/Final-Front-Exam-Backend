package com.example.finalExam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;
    private String name;
    private String status;
    private Integer quantity;
    private BigDecimal price;
}

package com.example.finalExam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductByIdResponseDto {
    private String name;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private String comment;
    private Integer rating;
    private Integer avgRating;
}

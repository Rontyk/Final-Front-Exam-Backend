package com.example.finalExam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductForWishListResponseDto {
    private String name;
    private BigDecimal price;
    private Integer stock;
}

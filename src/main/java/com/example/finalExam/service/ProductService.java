package com.example.finalExam.service;

import com.example.finalExam.dto.request.ProductRequestDto;
import com.example.finalExam.dto.response.ProductResponseDto;
import com.example.finalExam.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponseDto> getProductsByFilters(ProductRequestDto productRequestDto);
}

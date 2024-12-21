package com.example.finalExam.controller;

import com.example.finalExam.dto.request.ProductRequestDto;
import com.example.finalExam.dto.response.ProductByIdResponseDto;
import com.example.finalExam.dto.response.ProductResponseDto;
import com.example.finalExam.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getByFilters(@RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.ok(productService.getProductsByFilters(productRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductByIdResponseDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
}

package com.example.finalExam.controller;

import com.example.finalExam.dto.response.CategoriesResponseDto;
import com.example.finalExam.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoriesResponseDto>> getCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}

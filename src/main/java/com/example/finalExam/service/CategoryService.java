package com.example.finalExam.service;

import com.example.finalExam.dto.response.CategoriesResponseDto;

import java.util.List;

public interface CategoryService {

    List<CategoriesResponseDto> getAllCategories();
}

package com.example.finalExam.service.impl;

import com.example.finalExam.dto.response.CategoriesResponseDto;
import com.example.finalExam.entities.Category;
import com.example.finalExam.repositories.CategoryRepository;
import com.example.finalExam.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    @Override
    public List<CategoriesResponseDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<Category> rootCategories = categories.stream()
                .filter(category -> category.getParent() == null)
                .toList();

        return rootCategories.stream()
                .map(category -> new CategoriesResponseDto(
                        category.getName(),
                        mapSubCategories(category.getSubcategories())
                ))
                .toList();
    }

    private List<CategoriesResponseDto.SubCategory> mapSubCategories(List<Category> subcategories) {
        return subcategories.stream()
                .map(subCategory -> new CategoriesResponseDto.SubCategory(subCategory.getName()))
                .toList();
    }

}

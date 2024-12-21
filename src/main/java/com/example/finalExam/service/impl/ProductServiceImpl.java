package com.example.finalExam.service.impl;

import com.example.finalExam.dto.request.ProductRequestDto;
import com.example.finalExam.dto.response.ProductResponseDto;
import com.example.finalExam.entities.Category;
import com.example.finalExam.entities.Product;
import com.example.finalExam.exception.DbNotFoundException;
import com.example.finalExam.repositories.CategoryRepository;
import com.example.finalExam.repositories.ProductRepository;
import com.example.finalExam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDto> getProductsByFilters(ProductRequestDto productRequestDto) {
        List<Product> products = new ArrayList<>();

        if (productRequestDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                    .orElseThrow(() -> new DbNotFoundException(
                            HttpStatus.NOT_FOUND.getReasonPhrase(),
                            "Category not found"
                    ));
            products = category.getProducts();
        } else {
            products = productRepository.findAll();
        }

        if (productRequestDto.getPriceMin() != null) {
            products = products.stream()
                    .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(productRequestDto.getPriceMin())) >= 0)
                    .collect(Collectors.toList());
        }

        if (productRequestDto.getPriceMax() != null) {
            products = products.stream()
                    .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(productRequestDto.getPriceMax())) <= 0)
                    .collect(Collectors.toList());
        }

        if (productRequestDto.getSearch() != null && !productRequestDto.getSearch().isEmpty() && !productRequestDto.getSearch().equals("null")) {
            String search = productRequestDto.getSearch().toLowerCase();
            products = products.stream()
                    .filter(product -> product.getName().toLowerCase().contains(search) ||
                            (product.getDescription() != null && product.getDescription().toLowerCase().contains(search)))
                    .collect(Collectors.toList());
        }

        return products.stream()
                .map(product -> new ProductResponseDto(
                        product.getName(),
                        product.getPrice(),
                        product.getDescription(),
                        product.getStock()
                ))
                .collect(Collectors.toList());
    }
}

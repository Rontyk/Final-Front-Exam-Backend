package com.example.finalExam.service;

import com.example.finalExam.dto.response.ProductForWishListResponseDto;

import java.util.List;

public interface WishlistService {
    List<ProductForWishListResponseDto> findWishList();
}

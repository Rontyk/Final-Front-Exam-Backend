package com.example.finalExam.service;

import com.example.finalExam.dto.request.WishlistRequestDto;

import java.util.List;

public interface OrderService {

    void createOrderFromWishlist(Long userId, List<WishlistRequestDto> requestDtos);
}

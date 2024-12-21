package com.example.finalExam.service;

import com.example.finalExam.dto.request.WishlistRequestDto;
import com.example.finalExam.dto.response.OrderResponseDto;

import java.util.List;

public interface OrderService {

    void createOrderFromWishlist(Long userId, List<WishlistRequestDto> requestDtos);

    List<OrderResponseDto> getOrdersByUserId(Long id);
}

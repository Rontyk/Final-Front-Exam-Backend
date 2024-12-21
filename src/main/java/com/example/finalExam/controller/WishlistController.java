package com.example.finalExam.controller;

import com.example.finalExam.dto.response.ProductForWishListResponseDto;
import com.example.finalExam.entities.Wishlist;
import com.example.finalExam.service.WishlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wishlist")
@Slf4j
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping
    public ResponseEntity<List<ProductForWishListResponseDto>> getWishList(){
        return ResponseEntity.ok(wishlistService.findWishList());
    }
}

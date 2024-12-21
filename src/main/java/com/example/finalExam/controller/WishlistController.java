package com.example.finalExam.controller;

import com.example.finalExam.dto.response.ProductForWishListResponseDto;
import com.example.finalExam.entities.Wishlist;
import com.example.finalExam.service.WishlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long id){
        wishlistService.deleteByProductId(id);
        return ResponseEntity.status(200).build();
    }
}

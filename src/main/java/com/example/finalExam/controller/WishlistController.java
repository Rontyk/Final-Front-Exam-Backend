package com.example.finalExam.controller;

import com.example.finalExam.dto.request.WishlistRequestDto;
import com.example.finalExam.dto.response.ProductForWishListResponseDto;
import com.example.finalExam.entities.Order;
import com.example.finalExam.entities.User;
import com.example.finalExam.entities.Wishlist;
import com.example.finalExam.security.UserPrincipal;
import com.example.finalExam.service.OrderService;
import com.example.finalExam.service.WishlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wishlist")
@Slf4j
public class WishlistController {
    private final WishlistService wishlistService;
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<ProductForWishListResponseDto>> getWishList(){
        return ResponseEntity.ok(wishlistService.findWishList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long id){
        wishlistService.deleteByProductId(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/to-order")
    @Transactional
    public ResponseEntity<Void> convertWishlistToOrder(@RequestBody List<WishlistRequestDto> requestDtos) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof UserPrincipal)) {
            throw new IllegalStateException("User does not authenticated");
        }

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Long userId = userPrincipal.getUser().getId();

        orderService.createOrderFromWishlist(userId, requestDtos);
        return ResponseEntity.status(201).build();
    }

}

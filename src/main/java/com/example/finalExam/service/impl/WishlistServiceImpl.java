package com.example.finalExam.service.impl;

import com.example.finalExam.dto.response.ProductForWishListResponseDto;
import com.example.finalExam.entities.Product;
import com.example.finalExam.entities.User;
import com.example.finalExam.entities.Wishlist;
import com.example.finalExam.repositories.UserRepository;
import com.example.finalExam.repositories.WishlistRepository;
import com.example.finalExam.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishListRepository;
    private final UserRepository userRepository;

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            return userRepository.findUserByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        } else {
            throw new RuntimeException("Authentication principal is not an instance of UserDetails");
        }
    }


    @Override
    public List<ProductForWishListResponseDto> findWishList() {
        User user = getCurrentUser();

        List<Wishlist> wishLists = wishListRepository.findAllByUser(user);

        return wishLists.stream()
                .map(wishList -> {
                    Product product = wishList.getProduct();
                    return new ProductForWishListResponseDto(
                            product.getName(),
                            product.getPrice(),
                            product.getStock()
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByProductId(Long id) {
        User currentUser = getCurrentUser();

        Wishlist wishList = wishListRepository.findByUserAndProductId(currentUser, id)
                .orElseThrow(() -> new RuntimeException("Wishlist item not found for product ID: " + id));

        wishListRepository.delete(wishList);
    }

}

package com.example.finalExam.repositories;

import com.example.finalExam.entities.User;
import com.example.finalExam.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findAllByUser(User user);

    Optional<Wishlist> findByUserAndProductId(User user, Long productId);

    List<Wishlist> findByUserId(Long id);

    void deleteByUser(User user);
}

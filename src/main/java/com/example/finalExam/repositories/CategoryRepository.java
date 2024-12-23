package com.example.finalExam.repositories;

import com.example.finalExam.entities.Category;
import com.example.finalExam.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.ProductCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCollectionRepository extends JpaRepository<ProductCollection, Integer> {
}
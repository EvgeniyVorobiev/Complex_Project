package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.DishProduct;
import com.complex_project.balanced_nutrition.entity.DishProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishProductRepository extends JpaRepository<DishProduct, DishProductId> {
}
package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.ProductMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMeasureRepository extends JpaRepository<ProductMeasure, Integer> {
}
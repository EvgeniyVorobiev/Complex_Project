package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.ProductMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductMeasureRepository extends JpaRepository<ProductMeasure, Integer> {
    @Query("select pm from ProductMeasure pm")
    List<ProductMeasure> getAllProductMeasure();
}
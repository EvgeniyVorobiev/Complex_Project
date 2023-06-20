package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.DishProcessing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishProcessingRepository extends JpaRepository<DishProcessing, Integer> {
}
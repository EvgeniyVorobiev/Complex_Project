package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.MealDish;
import com.complex_project.balanced_nutrition.entity.MealDishId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealDishRepository extends JpaRepository<MealDish, MealDishId> {
}
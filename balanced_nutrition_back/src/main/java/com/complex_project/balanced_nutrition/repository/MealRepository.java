package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
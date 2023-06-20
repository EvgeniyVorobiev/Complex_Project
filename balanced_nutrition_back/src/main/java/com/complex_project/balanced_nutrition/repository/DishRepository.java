package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
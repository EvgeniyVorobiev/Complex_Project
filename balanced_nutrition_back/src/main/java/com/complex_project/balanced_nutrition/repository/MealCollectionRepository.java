package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.MealCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealCollectionRepository extends JpaRepository<MealCollection, Integer> {
}
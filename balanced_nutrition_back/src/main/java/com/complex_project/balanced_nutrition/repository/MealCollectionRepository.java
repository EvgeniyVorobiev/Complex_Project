package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.GroupPm;
import com.complex_project.balanced_nutrition.entity.MealCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealCollectionRepository extends JpaRepository<MealCollection, Integer> {
    @Query("Select m from MealCollection m")
    List<MealCollection> getAllMeals();
}
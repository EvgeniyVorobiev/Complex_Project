package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.DishCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishCollectionRepository extends JpaRepository<DishCollection, Integer> {
}
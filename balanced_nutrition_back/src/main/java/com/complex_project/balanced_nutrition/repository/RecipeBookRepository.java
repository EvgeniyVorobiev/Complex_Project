package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.RecipeBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeBookRepository extends JpaRepository<RecipeBook, Integer> {
}
package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.DishCollection;
import com.complex_project.balanced_nutrition.entity.RecipeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeBookRepository extends JpaRepository<RecipeBook, Integer> {
    @Query("select rb from RecipeBook rb")
    List<RecipeBook> getAllRecipeBooks();

    @Query("select rb from RecipeBook rb where rb.id = ?1")
    RecipeBook getRecipeBookById(Integer id);

    @Query("select rb from RecipeBook rb join DishCollection dc where rb.idDishCollection = ?1")
    List<RecipeBook> getRecipeBookByDishCollection(DishCollection dishCollection);
}
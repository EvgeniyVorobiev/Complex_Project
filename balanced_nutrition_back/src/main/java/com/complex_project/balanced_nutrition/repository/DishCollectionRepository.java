package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.DishCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishCollectionRepository extends JpaRepository<DishCollection, Integer> {
    @Query("select dc from DishCollection dc")
    List<DishCollection> getAllDishCollections();
    @Query("select count(d) from Dish d join RecipeBook rb join DishCollection dc where dc.id = ?1")
    int numberOfDishes(Integer id);
    @Query("select dc from DishCollection dc where dc.id = ?1")
    DishCollection getById(Integer id);
}
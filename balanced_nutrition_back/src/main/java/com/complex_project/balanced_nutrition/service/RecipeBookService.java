package com.complex_project.balanced_nutrition.service;

import com.complex_project.balanced_nutrition.entity.DishCollection;
import com.complex_project.balanced_nutrition.entity.RecipeBook;

import java.util.List;

public interface RecipeBookService {
    List<RecipeBook> getAllRecipeBooks();
    RecipeBook createRecipeBook(String name, String imageLink, DishCollection dishCollection);
    RecipeBook getById(Integer id);
    List<RecipeBook> getByDishCollection(DishCollection dishCollection);
}

package com.complex_project.balanced_nutrition.service.impl;

import com.complex_project.balanced_nutrition.entity.DishCollection;
import com.complex_project.balanced_nutrition.entity.RecipeBook;
import com.complex_project.balanced_nutrition.repository.RecipeBookRepository;
import com.complex_project.balanced_nutrition.service.RecipeBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeBookServiceImpl implements RecipeBookService {
    private final RecipeBookRepository recipeBookRepository;

    public RecipeBookServiceImpl(RecipeBookRepository recipeBookRepository) {
        super();
        this.recipeBookRepository = recipeBookRepository;
    }

    @Override
    public List<RecipeBook> getAllRecipeBooks() {
        return recipeBookRepository.getAllRecipeBooks();
    }

    @Override
    public RecipeBook createRecipeBook(String name, String imageLink, DishCollection dishCollection) {
        RecipeBook recipeBook = new RecipeBook();
        recipeBook.setName(name);
        recipeBook.setImageLink(imageLink);
        recipeBook.setIdDishCollection(dishCollection);
        return recipeBookRepository.save(recipeBook);
    }

    @Override
    public RecipeBook getById(Integer id) {
        return recipeBookRepository.getRecipeBookById(id);
    }

    @Override
    public List<RecipeBook> getByDishCollection(DishCollection dishCollection) {
        return recipeBookRepository.getRecipeBookByDishCollection(dishCollection);
    }

}

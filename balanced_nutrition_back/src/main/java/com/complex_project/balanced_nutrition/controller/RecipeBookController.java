package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.dto.DishCollectionDto;
import com.complex_project.balanced_nutrition.dto.RecipeBookDto;
import com.complex_project.balanced_nutrition.entity.DishCollection;
import com.complex_project.balanced_nutrition.entity.RecipeBook;
import com.complex_project.balanced_nutrition.repository.RecipeBookRepository;
import com.complex_project.balanced_nutrition.service.DishCollectionService;
import com.complex_project.balanced_nutrition.service.RecipeBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipeBook")
public class RecipeBookController {
    private final RecipeBookRepository recipeBookRepository;
    private final RecipeBookService recipeBookService;
    private final DishCollectionService dishCollectionService;

    @PostMapping("/create")
    public ResponseEntity<RecipeBook> createRecipeBook(@RequestBody() RecipeBookDto recipeBookDto){
        RecipeBook recipeBook = recipeBookService.createRecipeBook(recipeBookDto.getName(),
                recipeBookDto.getImageLink(), dishCollectionService.getById(recipeBookDto.getIdDishCollection().getId()));
        return new ResponseEntity<>(recipeBook, HttpStatus.CREATED);
    }
    @GetMapping("/AllRecipeBooks")
    public ResponseEntity<List<RecipeBook>> getAll(){
        List<RecipeBook> recipeBooks = recipeBookService.getAllRecipeBooks();
        return new ResponseEntity<>(recipeBooks, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RecipeBook> getById(@PathVariable Integer id){
        RecipeBook recipeBook = recipeBookService.getById(id);
        return  new ResponseEntity<>(recipeBook, HttpStatus.OK);
    }
}

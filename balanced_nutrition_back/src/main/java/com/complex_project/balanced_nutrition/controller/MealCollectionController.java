package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.entity.GroupPm;
import com.complex_project.balanced_nutrition.entity.MealCollection;
import com.complex_project.balanced_nutrition.service.GroupPmService;
import com.complex_project.balanced_nutrition.service.MealCollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mealCollection")
public class MealCollectionController {
    private final MealCollectionService mealCollectionService;

    @GetMapping("/getAllMeals")
    public ResponseEntity<List<MealCollection>> getAllMeals(){
        List<MealCollection> allMeals = mealCollectionService.getAllMeals();
        if (allMeals != null){

            return new ResponseEntity<>(allMeals, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}

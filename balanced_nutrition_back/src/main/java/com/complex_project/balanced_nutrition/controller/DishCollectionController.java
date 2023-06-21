package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.dto.UserCpDto;
import com.complex_project.balanced_nutrition.entity.DishCollection;
import com.complex_project.balanced_nutrition.entity.UserCp;
import com.complex_project.balanced_nutrition.repository.DishCollectionRepository;
import com.complex_project.balanced_nutrition.service.DishCollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishCollection")
public class DishCollectionController {
    private final DishCollectionRepository dishCollectionRepository;
    private final DishCollectionService dishCollectionService;
    @PostMapping("/create/{dishCollectionName}/{userCp}")
    public ResponseEntity<DishCollection> createDishCollection(@PathVariable String dishCollectionName, @PathVariable UserCp userCp){
        DishCollection dishCollection = dishCollectionService.createDishCollection(dishCollectionName, userCp);
        return new ResponseEntity<>(dishCollection, HttpStatus.CREATED);
    }

}
;
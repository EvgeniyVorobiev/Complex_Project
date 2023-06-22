package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.dto.DishCollectionDto;
import com.complex_project.balanced_nutrition.dto.UserCpDto;
import com.complex_project.balanced_nutrition.entity.DishCollection;
import com.complex_project.balanced_nutrition.entity.UserCp;
import com.complex_project.balanced_nutrition.repository.DishCollectionRepository;
import com.complex_project.balanced_nutrition.service.DishCollectionService;
import com.complex_project.balanced_nutrition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishCollection")
public class DishCollectionController {
    private final DishCollectionRepository dishCollectionRepository;
    private final DishCollectionService dishCollectionService;
    private final UserService userService;
    @PostMapping("/create")
    public ResponseEntity<DishCollection> createDishCollection(@RequestBody()DishCollectionDto dishCollectionDto){
        DishCollection dishCollection = dishCollectionService.createDishCollection(dishCollectionDto.getName(),
                userService.getUserById(dishCollectionDto.getIdUser().getId()));
        return new ResponseEntity<>(dishCollection, HttpStatus.CREATED);
    }
    @GetMapping("/numberOfDishes/{id}")
    public ResponseEntity<Integer> getNumberOfDishes(@PathVariable Integer id){
        Integer numberOfDishes = dishCollectionService.numberOfDishes(id);
        //if (numberOfDishes != null){
            return  new ResponseEntity<>(numberOfDishes, HttpStatus.OK);
        //}
        //return new ResponseEntity<>(0, HttpStatus.OK);
    }
    @GetMapping("/AllDishCollections")
    public ResponseEntity<List<DishCollection>> getAllDishCollections(){
        List<DishCollection> dishCollections = dishCollectionService.getAllDishCollections();
        return new ResponseEntity<>(dishCollections, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DishCollection> getById(@PathVariable int id){
        DishCollection dishCollection = dishCollectionService.getById(id);
        return new ResponseEntity<>(dishCollection, HttpStatus.OK);
    }
}
;
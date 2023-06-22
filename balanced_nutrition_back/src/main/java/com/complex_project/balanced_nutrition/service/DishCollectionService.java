package com.complex_project.balanced_nutrition.service;

import com.complex_project.balanced_nutrition.entity.DishCollection;
import com.complex_project.balanced_nutrition.entity.UserCp;

import java.util.List;

public interface DishCollectionService {
    DishCollection createDishCollection(String dishCollectionName, UserCp id_user);
    List<DishCollection> getAllDishCollections();
    DishCollection getById(Integer id);
    int numberOfDishes(Integer id);
}

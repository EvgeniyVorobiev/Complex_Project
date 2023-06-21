package com.complex_project.balanced_nutrition.service;

import com.complex_project.balanced_nutrition.entity.DishCollection;
import com.complex_project.balanced_nutrition.entity.UserCp;

public interface DishCollectionService {
    DishCollection createDishCollection(String dishCollectionName, UserCp id_user);
}

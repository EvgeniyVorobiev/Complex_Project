package com.complex_project.balanced_nutrition.service.impl;

import com.complex_project.balanced_nutrition.entity.GroupPm;
import com.complex_project.balanced_nutrition.entity.MealCollection;
import com.complex_project.balanced_nutrition.repository.MealCollectionRepository;
import com.complex_project.balanced_nutrition.service.MealCollectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealCollectionServiceImpl implements MealCollectionService {
    private final MealCollectionRepository mealCollectionRepository;


    public MealCollectionServiceImpl(MealCollectionRepository mealCollectionRepository) {
        super();
        this.mealCollectionRepository = mealCollectionRepository;
    }
    @Override
    public List<MealCollection> getAllMeals() {
        return mealCollectionRepository.getAllMeals();
    }
}

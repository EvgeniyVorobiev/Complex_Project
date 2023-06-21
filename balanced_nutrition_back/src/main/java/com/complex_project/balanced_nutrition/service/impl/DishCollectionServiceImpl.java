package com.complex_project.balanced_nutrition.service.impl;

import com.complex_project.balanced_nutrition.entity.DishCollection;
import com.complex_project.balanced_nutrition.entity.UserCp;
import com.complex_project.balanced_nutrition.repository.DishCollectionRepository;
import com.complex_project.balanced_nutrition.service.DishCollectionService;
import org.springframework.stereotype.Service;

@Service
public class DishCollectionServiceImpl implements DishCollectionService {
    private final DishCollectionRepository dishCollectionRepository;

    public DishCollectionServiceImpl(DishCollectionRepository dishCollectionRepository) {
        super();
        this.dishCollectionRepository = dishCollectionRepository;
    }

    @Override
    public DishCollection createDishCollection(String dishCollectionName, UserCp id_user) {
        DishCollection dishCollection = new DishCollection();
        dishCollection.setName(dishCollectionName);
        dishCollection.setIdUser(id_user);

        return dishCollectionRepository.save(dishCollection);
    }
}

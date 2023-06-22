package com.complex_project.balanced_nutrition.service;

import com.complex_project.balanced_nutrition.entity.ProductCollection;
import com.complex_project.balanced_nutrition.entity.UserCp;

import java.util.List;

public interface ProductCollectionService {
    List<ProductCollection> getAllProductCollections();
    ProductCollection getProductCollectionById(Integer id);
    ProductCollection createProductCollection(String name, String image_link, UserCp userCp);

}

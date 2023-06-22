package com.complex_project.balanced_nutrition.service.impl;


import com.complex_project.balanced_nutrition.entity.ProductCollection;
import com.complex_project.balanced_nutrition.entity.UserCp;
import com.complex_project.balanced_nutrition.repository.ProductCollectionRepository;
import com.complex_project.balanced_nutrition.service.ProductCollectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCollectionServiceImpl implements ProductCollectionService {
    private final ProductCollectionRepository productCollectionRepository;

    public ProductCollectionServiceImpl(ProductCollectionRepository productCollectionRepository) {
        super();
        this.productCollectionRepository = productCollectionRepository;
    }

    @Override
    public List<ProductCollection> getAllProductCollections() {
        return productCollectionRepository.getAllProductCollections();
    }

    @Override
    public ProductCollection getProductCollectionById(Integer id) {
        return productCollectionRepository.getProductCollectionById(id);
    }

    @Override
    public ProductCollection createProductCollection(String name, String image_link, UserCp userCp) {
        ProductCollection productCollection = new ProductCollection();
        productCollection.setName(name);
        productCollection.setImageLink(image_link);
        productCollection.setIdUser(userCp);
        return productCollectionRepository.save(productCollection);
    }
}

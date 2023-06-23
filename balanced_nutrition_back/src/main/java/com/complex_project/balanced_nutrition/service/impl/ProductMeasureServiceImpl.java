package com.complex_project.balanced_nutrition.service.impl;

import com.complex_project.balanced_nutrition.entity.ProductMeasure;
import com.complex_project.balanced_nutrition.repository.ProductMeasureRepository;
import com.complex_project.balanced_nutrition.service.ProductMeasureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMeasureServiceImpl implements ProductMeasureService {
    private final ProductMeasureRepository productMeasureRepository;

    public ProductMeasureServiceImpl(ProductMeasureRepository productMeasureRepository) {
        super();
        this.productMeasureRepository = productMeasureRepository;
    }

    @Override
    public List<ProductMeasure> getAllProductMeasure() {
        return productMeasureRepository.getAllProductMeasure();
    }
}

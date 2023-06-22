package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.ProductCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductCollectionRepository extends JpaRepository<ProductCollection, Integer> {
    @Query("select pc from ProductCollection pc")
    List<ProductCollection> getAllProductCollections();

    @Query("select pc from ProductCollection pc where pc.id = ?1")
    ProductCollection getProductCollectionById(Integer id);
}
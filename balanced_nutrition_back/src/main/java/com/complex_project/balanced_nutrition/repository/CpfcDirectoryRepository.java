package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.CpfcDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CpfcDirectoryRepository extends JpaRepository<CpfcDirectory, Integer> {
    @Query("select nutrient from CpfcDirectory nutrient")
    List<CpfcDirectory> getAllNutrients();
}
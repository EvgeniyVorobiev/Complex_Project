package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.CpfcDirectory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpfcDirectoryRepository extends JpaRepository<CpfcDirectory, Integer> {
}
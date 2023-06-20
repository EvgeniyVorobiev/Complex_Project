package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.PlannedMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlannedMenuRepository extends JpaRepository<PlannedMenu, Integer> {
}
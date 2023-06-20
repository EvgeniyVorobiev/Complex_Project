package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Integer> {
}
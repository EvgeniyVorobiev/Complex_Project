package com.complex_project.balanced_nutrition.repository;

import com.complex_project.balanced_nutrition.entity.GroupPm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupPmRepository extends JpaRepository<GroupPm, Integer> {

    @Query("Select g from GroupPm g")
    List<GroupPm> getAllGroups();
}
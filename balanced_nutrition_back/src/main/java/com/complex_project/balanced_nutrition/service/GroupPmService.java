package com.complex_project.balanced_nutrition.service;

import com.complex_project.balanced_nutrition.entity.GroupPm;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GroupPmService {
    List<GroupPm> geAllGroups();
}

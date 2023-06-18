package com.complex_project.balanced_nutrition.service;

import com.complex_project.balanced_nutrition.dto.RoleDto;
import com.complex_project.balanced_nutrition.entity.Role;

public interface RoleService {
    RoleDto getRoleDtoById(Short id);
    Role getRoleById(int id);
}

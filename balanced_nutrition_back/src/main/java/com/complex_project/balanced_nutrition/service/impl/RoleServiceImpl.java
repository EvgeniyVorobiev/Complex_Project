package com.complex_project.balanced_nutrition.service.impl;

import com.complex_project.balanced_nutrition.dto.RoleDto;
import com.complex_project.balanced_nutrition.entity.Role;
import com.complex_project.balanced_nutrition.repository.RoleRepository;
import com.complex_project.balanced_nutrition.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository){
        super();
        this.roleRepository = roleRepository;
    }
    @Override
    public RoleDto getRoleDtoById(Short id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role != null){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(role, RoleDto.class);
        }
        return null;
    }

    @Override
    public Role getRoleById(int id) {
        return roleRepository.findById(Short.valueOf((short) id)).get();
    }
}


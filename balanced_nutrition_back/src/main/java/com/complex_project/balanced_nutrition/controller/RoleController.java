package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.dto.RoleDto;
import com.complex_project.balanced_nutrition.entity.Role;
import com.complex_project.balanced_nutrition.service.RoleService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;
    private Role role;

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable short id) {
        //LOGGER.info("get role by id: " + id);
        Role role = roleService.getRoleById(id);
        if (role != null) {
            return new ResponseEntity<>(role, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}

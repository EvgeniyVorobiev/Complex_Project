package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.dto.RoleDto;
import com.complex_project.balanced_nutrition.dto.UserCpDto;
import com.complex_project.balanced_nutrition.entity.GroupPm;
import com.complex_project.balanced_nutrition.entity.UserCp;
import com.complex_project.balanced_nutrition.service.GroupPmService;
import com.complex_project.balanced_nutrition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupPmController {
    private final GroupPmService groupPmService;
    //private GroupPm groupPm;

    @GetMapping("/getAllGroups")
    public ResponseEntity<List<GroupPm>> getAllGroups(){
        List<GroupPm> allGroups = groupPmService.geAllGroups();
        if (allGroups != null){

            return new ResponseEntity<>(allGroups, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}

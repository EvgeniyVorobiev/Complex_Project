package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.entity.CpfcDirectory;
import com.complex_project.balanced_nutrition.service.CpfcDirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cpfcDirectory")
public class CpfcDirectoryController {
    private final CpfcDirectoryService cpfcDirectoryService;
    @GetMapping("/allNutrients")
    public ResponseEntity<List<CpfcDirectory>> getAllNutrients(){
        List<CpfcDirectory> nutrients = cpfcDirectoryService.getAllNutrients();
        return new ResponseEntity<>(nutrients, HttpStatus.OK);
    }
}

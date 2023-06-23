package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.entity.ProductMeasure;
import com.complex_project.balanced_nutrition.service.ProductMeasureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productMeasure")
public class ProductMeasureController {
    private final ProductMeasureService productMeasureService;
    @GetMapping("/all")
    ResponseEntity<List<ProductMeasure>> getAll(){
        List<ProductMeasure> allProductMeasure = productMeasureService.getAllProductMeasure();
        return new ResponseEntity<>(allProductMeasure, HttpStatus.OK);
    }

}

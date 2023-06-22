package com.complex_project.balanced_nutrition.controller;

import com.complex_project.balanced_nutrition.dto.ProductCollectionDto;
import com.complex_project.balanced_nutrition.entity.ProductCollection;
import com.complex_project.balanced_nutrition.repository.UserCpRepository;
import com.complex_project.balanced_nutrition.service.ProductCollectionService;
import com.complex_project.balanced_nutrition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productCollection")
public class ProductCollectionController {
    private final ProductCollectionService productCollectionService;
    private final UserCpRepository userCpRepository;
    private final UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<ProductCollection> getProductCollectionById(@PathVariable Integer id){
        ProductCollection productCollection = productCollectionService.getProductCollectionById(id);
        return new ResponseEntity<>(productCollection, HttpStatus.OK);
    }
    @GetMapping("/AllProductCollections")
    public ResponseEntity<List<ProductCollection>> getAllProductCollections(){
        List<ProductCollection> productCollections = productCollectionService.getAllProductCollections();
        return new ResponseEntity<>(productCollections, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ProductCollection> createProductCollection(@RequestBody ProductCollectionDto productCollectionDto){
        ProductCollection productCollection = productCollectionService.createProductCollection(productCollectionDto.getName(),
                productCollectionDto.getImageLink(), userService.getUserById(productCollectionDto.getIdUser().getId()));
        return new ResponseEntity<>(productCollection, HttpStatus.CREATED);
    }
}

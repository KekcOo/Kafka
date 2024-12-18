package com.example.testkafka.controller;

import com.example.testkafka.service.Dto.CreateProductDto;
import com.example.testkafka.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/")
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;

    @PostMapping
    public ResponseEntity<String>createProduct(@RequestBody CreateProductDto product){
        String productId = productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productId);

    }
}

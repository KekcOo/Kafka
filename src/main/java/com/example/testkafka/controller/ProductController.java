package com.example.testkafka.controller;

import com.example.testkafka.exeption.ErrorMessage;
import com.example.testkafka.service.Dto.CreateProductDto;
import com.example.testkafka.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private  final ProductService productService;

    @PostMapping
    public ResponseEntity<Object>createProduct(@RequestBody CreateProductDto product){
        String productId = null;
        try {
            productId = productService.createProduct(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(new Date(), e.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(productId);

    }
}

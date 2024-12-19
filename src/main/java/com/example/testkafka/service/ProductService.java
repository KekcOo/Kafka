package com.example.testkafka.service;

import com.example.testkafka.service.Dto.CreateProductDto;

import java.util.concurrent.ExecutionException;

public interface ProductService {
    String createProduct(CreateProductDto product) throws ExecutionException, InterruptedException;
}

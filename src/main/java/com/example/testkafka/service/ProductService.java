package com.example.testkafka.service;

import com.example.testkafka.service.Dto.CreateProductDto;

public interface ProductService {
    String createProduct(CreateProductDto product);
}

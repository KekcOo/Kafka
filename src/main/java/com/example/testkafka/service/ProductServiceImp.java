package com.example.testkafka.service;

import com.example.testkafka.service.Dto.CreateProductDto;
import com.example.testkafka.service.event.ProductCreateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService{

    private final  KafkaTemplate<String,ProductCreateEvent> kafkaTemplate;


    @Override
    public String createProduct(CreateProductDto productDto) throws ExecutionException, InterruptedException {
        String productId = UUID.randomUUID().toString();

        ProductCreateEvent productCreateEvent =
                new ProductCreateEvent(productId,productDto.getTitle(),productDto.getPrice(), productDto.getQuantity());
       SendResult<String,ProductCreateEvent> result =
        kafkaTemplate.send("product-created-events-topic",productId,productCreateEvent).get();


        log.info("return {}",productId);
        return productId;
    }
}

package com.example.testkafka.service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateEvent {
    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}

package com.example.demo.dto;

import com.example.demo.application.domain.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String name;
    private double price;
    private Integer stock;

    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductResponseDto from(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();

        return this;
    }

    public List<ProductResponseDto> from (List<Product> products) {
        return products.stream().map(this::from).collect(Collectors.toList());
    }
}



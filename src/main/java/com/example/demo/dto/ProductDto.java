package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter @Setter
@ToString
public class ProductDto {
    private String name;
    private double price;
    private Integer stock;

    private String description;

    private Long providerId;

    private Long categoryId;

}

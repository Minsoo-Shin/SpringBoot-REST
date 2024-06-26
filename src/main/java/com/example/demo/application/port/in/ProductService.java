package com.example.demo.application.port.in;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductDto productDto);

    ProductResponseDto getProduct(Long id);

    List<ProductResponseDto> listProducts(double minPrice, double maxPrice);

    void deleteProduct(Long id);

    ProductResponseDto updateProduct(Long id, ProductDto productDto);
}

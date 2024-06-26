package com.example.demo.service;

import com.example.demo.application.port.in.ProductService;
import com.example.demo.application.domain.service.ProductServiceImpl;
import com.example.demo.application.domain.entity.Product;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.adapter.out.persistence.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;


class ProductServiceImplTest {
    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    @DisplayName("listProducts test")
    void listProducts_test() {
        // given
        List<Product> products = List.of(
                Product.builder().name("product1").price(2000).stock(10).build(),
                Product.builder().name("product2").price(3000).stock(10).build()
        );
        // given
        Mockito
                .when(productRepository.findByPriceGreaterThanEqualAndPriceLessThanEqualOrderByIdDesc(2000, 3000))
                .thenReturn(products);
        // when
        List<ProductResponseDto> productResponseDtos = productService.listProducts(2000, 3000);

        // then
        assertThat(productResponseDtos.size()).isEqualTo(2);

    }
}
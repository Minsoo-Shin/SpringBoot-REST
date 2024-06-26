package com.example.demo.service;

import com.example.demo.application.domain.entity.Product;
import com.example.demo.application.domain.entity.ProductDetail;
import com.example.demo.adapter.out.persistence.ProductDetailRepository;
import com.example.demo.adapter.out.persistence.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductDetailServiceTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Test
    public void saveAndReadTest1() {

        ProductDetail productDetail = new ProductDetail();
        productDetail.setDescription("product1 description");

        productDetailRepository.save(productDetail);

        Product product = new Product();
        product.setName("product1");
        product.setPrice(1000);
        product.setStock(10);
        product.setProductDetail(productDetail);

        productRepository.save(product);

        System.out.println("productDetail.id = " + productDetail.getId());

        System.out.println(" savedProduct = " + productDetailRepository.findById(productDetail.getId()).get());

    }

}
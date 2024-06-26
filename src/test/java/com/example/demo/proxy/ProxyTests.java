package com.example.demo.proxy;

import com.example.demo.application.domain.entity.Product;
import com.example.demo.application.domain.entity.Provider;
import com.example.demo.adapter.out.persistence.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProxyTests {
    @Autowired
    ProductRepository productRepository;

    EntityManager em = Persistence.createEntityManagerFactory("com.example.WebApplication").createEntityManager();
    
    @Test
    @DisplayName("Name")
    void Name() {

        Provider provider = new Provider();
        provider.setName("provider1");

        Product product = new Product();
        product.setName("product1");
        product.setProvider(provider);

        productRepository.save(product);

        Product findProduct = em.find(Product.class, product.getId());
        System.out.println("findProduct = " + findProduct);

    }
}

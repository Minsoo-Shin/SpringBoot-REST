package com.example.demo.entitymanager.EntityManager;

import com.example.demo.application.domain.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class EntityManagerTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("em")
    @Transactional
    void em() {

        Product product = new Product();
        product.setName("product1");
        product.setStock(100);
        em.persist(product);

        em.flush();
        Product findProduct = em.find(Product.class, product.getId());
        findProduct.setStock(50);

        em.flush();

//        TypedQuery<Product> p = em.createQuery("select p from Product p", Product.class);
//        List<Product> resultList = p.getResultList();
//        for (Product product1 : resultList) {
//            System.out.println("product1 = " + product1.getStock());
//        }

    }
}

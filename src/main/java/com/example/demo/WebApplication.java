package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.reflect.Member;

@SpringBootApplication
@EnableTransactionManagement
public class WebApplication {


    public static void main(String[] args) {

        final ConfigurableApplicationContext applicationContext = SpringApplication.run(WebApplication.class, args);
    }

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void logic() {



        // 삭제
        em.close();
    }
}
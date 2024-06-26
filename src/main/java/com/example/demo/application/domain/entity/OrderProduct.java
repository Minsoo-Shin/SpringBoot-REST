package com.example.demo.application.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderProduct {

    @Id @GeneratedValue
    private Long id;

    /**
     * 주문상품은 주문과 다대일(N:1) 관계이다.
     * 주문상품이 주인이 되며, 주문상품에서 외래키를 관리합니다.
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
}

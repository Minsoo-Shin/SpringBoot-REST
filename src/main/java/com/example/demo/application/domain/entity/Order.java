package com.example.demo.application.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 주문은 주문상품 테이블과 다대일(1:N) 관계이다.
     * 주문상품 테이블이 주인이 되며, 주문상품 테이블에서 외래키를 관리합니다. (mappedBy 속성)
     */
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    private OrderStatus Status;

}

package com.example.demo.application.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // description of the item
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private Integer stock;

    /**
     * 상품은 공급자와 다대일(N:1) 관계이다.
     * 상품은 하나의 공급자에 속하며, 공급자는 여러 상품을 가질 수 있다.
     * 상품에서 공급자를 참조할 일이 있고, 공급자에서 상품을 참조할 일이 있으므로 양방향 관계로 설정합니다.
     * 연관관계의 주인은 상품이므로, 상품에서 외래키를 관리합니다.
     * 공급자는 mappedBy 속성으로 연관관계의 주인이 아님을 설정합니다.
     */
    @ManyToOne
    @JoinColumn(name = "provider_id")
    @ToString.Exclude
    private Provider provider;

    /**
     * 상품은 카테고리와 다대일(N:1) 관계이다.
     * 상품은 하나의 카테고리에 속하며, 카테고리는 여러 상품을 가질 수 있다.
     * 상품에서 카테고리를 참조할 일이 있고, 카테고리에서 상품을 참조할 일이 있으므로 양방향 관계로 설정합니다.
     * 연관관계의 주인은 상품이므로, 상품에서 외래키를 관리합니다.
     * 카테고리는 mappedBy 속성으로 연관관계의 주인이 아님을 설정합니다.
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private Category category;

    /**
     * 상품상세는 상품과 1:1 관계이다.
     * 상품상세는 상품이 저장/삭제되면 같이 저장/삭제됩니다.
     * 상품상세에서 상품에 대한 내용을 읽을 일이 없어 OneToOne 단방향 관계로 설정합니다.
     */
    @OneToOne
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetail;

}

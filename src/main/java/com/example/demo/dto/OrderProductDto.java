package com.example.demo.dto;

import com.example.demo.application.domain.entity.OrderProduct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class OrderProductDto {
    private Long productId;
    private int quantity;

    public OrderProductDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderProductDto from(OrderProduct orderProduct) {
        this.productId = orderProduct.getProduct().getId();
        this.quantity = orderProduct.getQuantity();
        return this;
    }

    public List<OrderProductDto> from(List<OrderProduct> orderProduct) {
        return orderProduct.stream().map(this::from).collect(Collectors.toList());
    }
}

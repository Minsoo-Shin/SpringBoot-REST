package com.example.demo.dto;

import com.example.demo.application.domain.entity.Order;
import com.example.demo.application.domain.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderResponseDto {
    private Long id;

    private List<OrderProductDto> orderProducts;
    private OrderStatus status;

    public OrderResponseDto() {
    }

    public OrderResponseDto from(Order order) {
        this.id = order.getId();
        this.orderProducts = new OrderProductDto().from(order.getOrderProducts());
        this.status = order.getStatus();
        return this;
    }
}

package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class OrderDto {
    private List<OrderProductDto> orderProduct;

    public OrderDto() {
    }
}

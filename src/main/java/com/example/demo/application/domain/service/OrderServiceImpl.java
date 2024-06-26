package com.example.demo.application.domain.service;

import com.example.demo.application.port.in.OrderService;
import com.example.demo.application.port.out.OrderPort;
import com.example.demo.application.port.out.ProductPort;
import com.example.demo.application.domain.entity.Order;
import com.example.demo.application.domain.entity.Product;
import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderPort orderPort;

    private final ProductPort productPort;

    @Autowired
    public OrderServiceImpl(OrderPort orderPort, ProductPort productPort) {
        this.orderPort = orderPort;
        this.productPort = productPort;
    }

    @Transactional
    @Override
    public OrderResponseDto saveOrder(OrderDto orderDto) {
        // 상품 재고의 Lock을 건다.
        orderDto.getOrderProduct().stream().forEach(orderProductDto -> {
            productPort.lockProduct(orderProductDto.getProductId());
        });

        // 상품의 재고가 있는지 확인한다. 재고가 없다면 예외를 발생시킨다.
        orderDto.getOrderProduct().stream().forEach(orderProductDto -> {
            Optional<Product> byId = productPort.findProductById(orderProductDto.getProductId());
            if (byId.isEmpty()) {
                throw new RuntimeException("상품이 없습니다.");
            }
            if (orderProductDto.getQuantity() > byId.get().getStock()) {
                throw new RuntimeException("재고가 부족합니다.");
            }
        });

        // 주문을 저장한다.
        Order saveOrder = orderPort.save(orderDto.getOrderProduct());

        // 상품 재고를 감소시킨다.
        orderDto.getOrderProduct().stream().forEach(orderProductDto -> {
            productPort.PurchaseProduct(orderProductDto.getProductId(), orderProductDto.getQuantity());
        });

        orderDto.getOrderProduct().stream().forEach(orderProductDto -> {
            productPort.unlockProduct(orderProductDto.getProductId());
        });

        return new OrderResponseDto().from(saveOrder);
    }

    @Override
    public OrderResponseDto getOrder(Long id) {
        Optional<Order> findById = orderPort.findById(id);
        Order order = findById.get();


        return new OrderResponseDto().from(order);
    }
}

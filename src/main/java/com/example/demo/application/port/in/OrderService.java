package com.example.demo.application.port.in;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderResponseDto saveOrder(OrderDto orderDto);

    OrderResponseDto getOrder(Long id);


}

package com.example.demo.adapter.in.web;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderResponseDto;
import com.example.demo.application.port.in.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderResource {

    @Autowired
    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }


    /**
     * 주문 생성
     *
     * @return
     */
    @PostMapping(value = "/order")
    public OrderResponseDto createOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }


    /**
     * 주문 조회
     *
     * @return
     */
    @GetMapping(value = "/order/{id}")
    public OrderResponseDto getOrder(@PathVariable("id") Long id) {
        return orderService.getOrder(id);
    }


}

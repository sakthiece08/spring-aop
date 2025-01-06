package org.teqmonic.springaop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.teqmonic.springaop.model.Order;

import java.util.ArrayList;
import java.util.List;


@RestController
public class OrderController {

    private final List<Order> orders = new ArrayList<>();

    private Long orderId = 0L;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/order")
    public Long placeOrder(@RequestBody Order orderRequest) {
       orderRequest.setId(++orderId);
       orders.add(orderRequest);
       return orderId;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/order/{order_id}")
    public Order retrieveOrder(@PathVariable(name = "order_id") Long orderId) {
       return orders.stream().filter(order -> orderId == order.getId()).findFirst().orElseThrow();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/order/{order_id}")
    public void deleteOrder(@PathVariable(name = "order_id") Long orderId) {
       Order deleteOrder = orders.stream().filter(order -> orderId == order.getId()).findFirst().orElseThrow();
       orders.remove(deleteOrder);
    }
}

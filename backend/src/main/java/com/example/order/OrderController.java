package com.example.order;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.create(order));
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Order>> getOrdersByVendorId(@PathVariable Long vendorId) {
        return ResponseEntity.ok(orderService.getOrdersByVendorId(vendorId));
    }
}

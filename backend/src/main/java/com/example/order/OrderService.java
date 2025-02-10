package com.example.order;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {
   private final OrderRepository orderRepository;

   public OrderService(OrderRepository orderRepository) {
      this.orderRepository = orderRepository;
   }

   public List<Order> getAll() {
      return orderRepository.findAll();
   }

   public Order create(Order order) {
      return orderRepository.save(order);
   }

  public List<Order> getOrdersByVendorId(Long vendorId) {
    return orderRepository.findOrdersByVendorId(vendorId);
  }
}

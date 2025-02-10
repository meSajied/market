package com.example.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
   @Query("SELECT DISTINCT o FROM Order o JOIN o.orderItems oi WHERE oi.product.vendor.id = :vendorId")
   List<Order> findOrdersByVendorId(Long vendorId);
}

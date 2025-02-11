package com.example.order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.customer.Customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product_order")
public class Order {
   enum Status {
      PROCESSING, SHIPPED, CANCELLED, REJECTED;
  }
   @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  private Customer customer;

  @OneToMany
  private List<OrderItem> orderItems;
  private String address;
  private Double amount;
  private LocalDateTime localDateTime;

  public Long getId() {
    return id;
  }
  public Customer getCustomer() {
    return customer;
  }
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  public List<OrderItem> getOrderItems() {
    return orderItems;
  }
  public void setOrderItems(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public Double getAmount() {
    return amount;
  }
  public void setAmount(Double amount) {
    this.amount = amount;
  }
  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }
  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }
  
  

}

package com.example.product;

import com.example.vendor.Vendor;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Product {

  enum Color {
      RED, BLACK, WHITE;
  }

  enum Size {
    S, M, XL;
}

    enum Status {
        ACTIVE, INACTIVE;
    }

    enum Stock {
        AVAILABLE, UNAVAILABLE;
    }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Long price;
  private Long discount;
  
  private String description;
  private Status status = Status.INACTIVE;
  private Stock stock;
  private Double comission;

  @ManyToOne
  @JsonBackReference
  private ParentCategory parentCategory;
  
  @ManyToOne
  @JsonBackReference
  private ChildCategory childCategory;

  @ManyToOne
  @JsonBackReference
  private Vendor vendor;

  @Enumerated(EnumType.STRING)
  private Color color;

  @Enumerated(EnumType.STRING)
  private Size size;

  public Long getId() {
      return id;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public Long getPrice() {
      return price;
  }

  public void setPrice(Long price) {
      this.price = price;
  }

  public Long getDiscount() {
      return discount;
  }

  public void setDiscount(Long discount) {
      this.discount = discount;
  }

  public String getDescription() {
      return description;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public Color getColor() {
      return color;
  }

  public void setColor(Color color) {
      this.color = color;
  }

  public Size getSize() {
    return size;
}

  public void setSize(Size size) {
      this.size = size;
  }

  public ParentCategory getParentCategory() {
    return parentCategory;
  }

  public void setParentCategory(ParentCategory parentCategory) {
     this.parentCategory = parentCategory;
  }

  public ChildCategory getChildCategory() {
     return childCategory;
  }

  public void setChildCategory(ChildCategory childCategory) {
     this.childCategory = childCategory;
  }

  public Status getStatus() {
     return status;
  }

  public void setStatus(Status status) {
     this.status = status;
  }

  public Stock getStock() {
     return stock;
  }

  public void setStock(Stock stock) {
     this.stock = stock;
  }

  public Double getComission() {
     return comission;
  }

  public void setComission(Double comission) {
     this.comission = comission;
  }

  public Vendor getVendor() {
     return vendor;
  }

  public void setVendor(Vendor vendor) {
     this.vendor = vendor;
  }
}

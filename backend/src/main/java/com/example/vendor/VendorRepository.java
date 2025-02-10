package com.example.vendor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.Product;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
   List<Product> findProductsByVendorId(Long id);
}

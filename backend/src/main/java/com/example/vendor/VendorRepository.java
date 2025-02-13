package com.example.vendor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.product.Product;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
   Optional<Vendor> findByPhoneAndPassword(String phone, String password);
}

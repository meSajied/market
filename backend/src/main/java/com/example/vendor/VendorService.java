package com.example.vendor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.product.Product;


@Service
@Transactional
public class VendorService {
   private final VendorRepository vendorRepository;

   public VendorService(VendorRepository vendorRepository) {
      this.vendorRepository = vendorRepository;
   }

   public List<Product> productsOfVendorOfId(Long id) {
      Optional<Vendor> vendorOp =  vendorRepository.findById(id);

      if(vendorOp.isPresent()) {
         System.out.println(vendorOp.get().getProducts());
         return vendorOp.get().getProducts();
      }

      return null;
   }

   public List<Vendor> getListOfVendors() {
      return vendorRepository.findAll();
   }

   public Optional<Vendor> getVendor(String phone, String password) {
      return vendorRepository.findByPhoneAndPassword(phone, password);
   }

   public Vendor create(Vendor vendor) {
      return vendorRepository.save(vendor);
   }

}

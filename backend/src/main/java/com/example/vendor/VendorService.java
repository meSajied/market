package com.example.vendor;

import java.util.List;
import java.util.Optional;

import com.example.product.Product;

public class VendorService {
   private final VendorRepository vendorRepository;

   public VendorService(VendorRepository vendorRepository) {
      this.vendorRepository = vendorRepository;
   }

   public List<Product> productsOfVendorOfId(Long id) {
      Optional<Vendor> vendorOp =  vendorRepository.findById(id);

      if(vendorOp.isPresent()) {
         return vendorOp.get().getProducts();
      }

      return null;
   }

   public List<Vendor> getListOfVendors() {
      return vendorRepository.findAll();
   }

}

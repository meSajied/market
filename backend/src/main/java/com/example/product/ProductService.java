package com.example.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
   private final ProductRepository productRepository;

   public ProductService(ProductRepository productRepository) {
      this.productRepository = productRepository;
   }

   public Product updateProduct(Product product) {
      Optional<Product> productOp = productRepository.findById(product.getId());

      if (productOp.isPresent()) {
         Product oldProduct = productOp.get();

         oldProduct.setName(product.getName());
         oldProduct.setPrice(product.getPrice());
         oldProduct.setDiscount(product.getDiscount());
         oldProduct.setDescription(product.getDescription());
         oldProduct.setStatus(product.getStatus());
         oldProduct.setStock(product.getStock());
         oldProduct.setColor(product.getColor());
         oldProduct.setSize(product.getSize());
         oldProduct.setParentCategory(product.getParentCategory());
         oldProduct.setChildCategory(product.getChildCategory());
         oldProduct.setComission(product.getComission());

         return productRepository.save(oldProduct);
      }

      return null;
   }

  public Product create(Product product) {
    return productRepository.save(product);
  }

  public List<Product> getAll() {
   return productRepository.findAll();
  }
}

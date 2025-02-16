package com.example.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
  private final ProductRepository productRepository;
  private final ParentCategoryRepository parentCategoryRepository;
  private final ChildCategoryRepository childCategoryRepository;

  public ProductService(ProductRepository productRepository, 
                        ParentCategoryRepository parentCategoryRepository, 
                        ChildCategoryRepository childCategoryRepository) {
    this.productRepository = productRepository;
    this.parentCategoryRepository = parentCategoryRepository;
    this.childCategoryRepository = childCategoryRepository;
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

      if (product.getParentCategory() != null) {
        ParentCategory parentCategory = parentCategoryRepository.findById(product.getParentCategory().getId()).orElseThrow(() -> new RuntimeException("Parent Category not found"));
        oldProduct.setParentCategory(parentCategory);
      } else {
        oldProduct.setParentCategory(null);
      }

      if (product.getChildCategory() != null) {
        ChildCategory childCategory = childCategoryRepository.findById(product.getChildCategory().getId()).orElseThrow(() -> new RuntimeException("Child Category not found"));
        oldProduct.setChildCategory(childCategory);
      } else {
        oldProduct.setChildCategory(null);
      }

      oldProduct.setComission(product.getComission());

      return productRepository.save(oldProduct);
    }

    throw new RuntimeException("Product not found");
  }
   
  public Product create(Product product) {
    
    return productRepository.save(product);
  }

  public List<Product> getAll() {
    return productRepository.findAll();
  }
}
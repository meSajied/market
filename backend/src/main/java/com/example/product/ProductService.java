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
        ParentCategory parentCategory = parentCategoryRepository.findByName(product.getParentCategory().getName()).get();
        oldProduct.setParentCategory(parentCategory);
      }else if(product.getParentCategory() == null) {
        ParentCategory parentCategory = parentCategoryRepository.save(product.getParentCategory());
        oldProduct.setParentCategory(parentCategory);
      }

      if (product.getChildCategory() != null) {
        ChildCategory childCategory = childCategoryRepository.findByName(product.getChildCategory().getName()).get();
        oldProduct.setChildCategory(childCategory);
      }else if(product.getChildCategory() == null) {
        ChildCategory childCategory = childCategoryRepository.save(product.getChildCategory());
        oldProduct.setChildCategory(childCategory);
      }

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

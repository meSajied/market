package com.example.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vendor.Vendor;
import com.example.vendor.VendorRepository;

@Service
@Transactional
public class ProductService {
  private final ProductRepository productRepository;
  private final ParentCategoryRepository parentCategoryRepository;
  private final ChildCategoryRepository childCategoryRepository;
  private final VendorRepository vendorRepository;

  public ProductService(ProductRepository productRepository, 
                        ParentCategoryRepository parentCategoryRepository, 
                        ChildCategoryRepository childCategoryRepository,
                        VendorRepository vendorRepository) {
    this.productRepository = productRepository;
    this.parentCategoryRepository = parentCategoryRepository;
    this.childCategoryRepository = childCategoryRepository;
    this.vendorRepository = vendorRepository;
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

  
      if (product.getChildCategory() != null) {
        ChildCategory childCategory = childCategoryRepository.findById(product.getChildCategory().getId()).orElseThrow(() -> new RuntimeException("Child Category not found"));
        oldProduct.setChildCategory(childCategory);
        List<Product>p = new ArrayList<>();
        p.add(product);
        childCategory.setProducts(p);
      } else {
        oldProduct.setChildCategory(null);
      }

      oldProduct.setComission(product.getComission());

      return productRepository.save(oldProduct);
    }

    throw new RuntimeException("Product not found");
  }
   
  public Product create(Product product) {
    ChildCategory childCategory = childCategoryRepository.findById(product.getChildCategory().getId()).orElseThrow(() -> new RuntimeException("Child Category not found"));
    Vendor vendor = vendorRepository.findById(product.getChildCategory().getId()).orElseThrow(() -> new RuntimeException("Vendor not found"));

    List<Product> p = new ArrayList<>();
    p.add(product);
    childCategory.setProducts(p);
    vendor.setProducts(p);
    product.setChildCategory(childCategory);
    product.setVendor(vendor);
    return productRepository.save(product);
  }

  public List<Product> getAll() {
    return productRepository.findAll();
  }

public Optional<Product> getproductOfId(Long id) {
   return productRepository.findById(id);
}
}
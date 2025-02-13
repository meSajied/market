package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;
    private final ParentCategoryService parentCategoryService;

    public ProductController(ProductService productService, ParentCategoryService parentCategoryService) {
        this.productService = productService;
        this.parentCategoryService = parentCategoryService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        System.out.println(product.getParentCategory());
        return productService.create(product);
        
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParentCategory>> getAllProducts() {
        List<ParentCategory> products = parentCategoryService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
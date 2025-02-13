package com.example.vendor;

import com.example.product.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendor")
@CrossOrigin(origins = "http://localhost:3000")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/login")
    public Optional<Vendor> login(@RequestBody AuthRequest vendor) {
      return vendorService.getVendor(vendor.getPhone(), vendor.getPassword());
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        List<Vendor> vendors = vendorService.getListOfVendors();
        return ResponseEntity.ok(vendors);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getProductsByVendor(@PathVariable Long id) {
        List<Product> products = vendorService.productsOfVendorOfId(id);
        return products != null ? ResponseEntity.ok(products) : ResponseEntity.notFound().build();
    }
}

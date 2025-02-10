package com.example.admin;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/admin")
public class AdminController {
  private final AdminService adminService;

  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

   @GetMapping("/login")
   public HttpStatus adminLogin(@RequestBody Admin admin) {
    if(admin.getUsername() == "admin" && admin.getPassword() == "Admin123") {
      return HttpStatus.OK;
    }
        return HttpStatus.NOT_FOUND;
   }
   
}

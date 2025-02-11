package com.example.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParentCategoryService {
   private final ParentCategoryRepository parentCategoryRepository;

   public ParentCategoryService(ParentCategoryRepository parentCategoryRepository) {
      this.parentCategoryRepository = parentCategoryRepository;
   }

   public ParentCategory create(ParentCategory parentCategory) {
      return parentCategoryRepository.save(parentCategory);
   }
}

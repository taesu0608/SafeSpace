package com.example.demo.product.category.repository;

import com.example.demo.product.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,String> {
    List<Category> findByCategoryName(String categoryName);
}

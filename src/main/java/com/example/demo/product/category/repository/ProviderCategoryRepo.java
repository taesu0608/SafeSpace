package com.example.demo.product.category.repository;

import com.example.demo.product.category.entity.Category;
import com.example.demo.provider.entity.Provider;
import com.example.demo.product.category.entity.ProviderCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderCategoryRepo extends JpaRepository<ProviderCategory,Integer> {
    List<ProviderCategory> findByProvider(Provider provider);
    List<ProviderCategory> findByCategory(Category category);
}

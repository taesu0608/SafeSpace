package com.example.demo.product.product.repository;

import com.example.demo.product.product.entity.Product;
import com.example.demo.provider.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,String> {
    Optional<Product> findById(String id);
    List<Product> findByProvider(Provider provider);
}

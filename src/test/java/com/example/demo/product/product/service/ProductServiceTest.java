package com.example.demo.product.product.service;

import com.example.demo.product.category.entity.Category;
import com.example.demo.product.product.entity.Product;
import com.example.demo.product.product.repository.ProductRepo;
import com.example.demo.provider.entity.Provider;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;

public class ProductServiceTest {

    @Mock
    ProductRepo productRepo;

    @InjectMocks
    ProductService productService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("개별 상품 저장")
    void saveProduct() {

        //필수값만 존재하는객체 준비
        Provider provider = Provider.builder()
                .providerId("prov-001")
                .name("Test Provider")
                .build();

        Category category = Category.builder()
                .id("cat-001")
                .categoryName("Test Category")
                .build();

        Product dummyProduct = Product.builder()
                .product_id("prod-001")
                .product_name("Test Product")
                .imgPath("test.png")
                .description("Dummy product for unit test")
                .capacity(100)
                .month(6)
                .price(9999)
                .provider(provider)
                .category(category)
                .build();
    }
}

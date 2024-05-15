package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 150)
    private Integer product_id;

    @Column(length = 100)
    private String product_name;

    @Column(length = 250)
    private String img_path;

    @Column(length = 100)
    private String category;

    @Column(length = 250)
    private String description;

    @Column
    private Integer capacity;

    @Column
    private Integer month;

    @Column
    private Integer price;

    @ManyToOne
    private Provider provider;


    @Builder
    public Product(String product_name, String img_path, String category, String description, Integer capacity, Integer month, Integer price) {
        this.product_name = product_name;
        this.img_path = img_path;
        this.category = category;
        this.description = description;
        this.capacity = capacity;
        this.month = month;
        this.price = price;
    }
}

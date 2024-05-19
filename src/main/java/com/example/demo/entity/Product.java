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
    @Column(nullable = false, length = 150)
    private String product_id;

    @Column(length = 100)
    private String product_name;

    @Column(length = 255)
    private String img_path;

    @Column(length = 100)
    private String category;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private Integer capacity;

    @Column(length = 100)
    private Integer month;

    @Column(length = 100)
    private Integer price;

    @ManyToOne
    private Provider provider;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<SubscribeInformation> subscribeInformation;

    @Builder
    public Product(String product_id,String product_name, String img_path, String category, String description, Integer capacity, Integer month, Integer price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.img_path = img_path;
        this.category = category;
        this.description = description;
        this.capacity = capacity;
        this.month = month;
        this.price = price;
    }
}

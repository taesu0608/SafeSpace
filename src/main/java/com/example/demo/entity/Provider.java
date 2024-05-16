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
@Table(name = "provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 150)
    private Integer provider_id;

    @Column(length = 100)
    private String name;

    @Column(length = 250)
    private String img_path;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Product> productList;

    @Builder
    public Provider(Integer provider_id, String name, String img_path) {
        this.provider_id = provider_id;
        this.name = name;
        this.img_path=img_path;
    }
}

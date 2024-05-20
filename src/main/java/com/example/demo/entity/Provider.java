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
public class Provider {
    @Id
    @Column(nullable = false, length = 150)
    private String provider_id;

    @Column(length = 100)
    private String name;

    @Column(length = 255)
    private String img_path;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Product> productList;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<SubscribeInformation> subscribeInformation;

    @Builder
    public Provider(String provider_id, String name, String img_path) {
        this.provider_id = provider_id;
        this.name = name;
        this.img_path=img_path;
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Provider {
    @Id
    @Column(nullable = false, length = 150)
    private String providerId;

    @Column(length = 100)
    private String name;

    @Column(length = 255)
    private String imgPath;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<Product> productList;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<SubscribeInformation> subscribeInformation;

    @Builder
    public Provider(String providerId, String name, String imgPath) {
        this.providerId = providerId;
        this.name = name;
        this.imgPath=imgPath;
    }
}

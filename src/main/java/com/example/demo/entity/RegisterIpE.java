package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@Table(name = "registerIp")
public class RegisterIpE {
    @Id
    @Column(length = 255)
    private String ip;

    @Column(length = 255)
    private String uid;

    @Builder
    public RegisterIpE(String ip, String uid){
        this.ip = ip;
        this.uid = uid;
    }
}

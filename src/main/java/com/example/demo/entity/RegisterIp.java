package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.ibatis.annotations.Many;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@Setter
@Table(name = "RegisterIp")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterIp {
    @Id
    @Column(length = 150)
    private String ip;

    @Column(length = 150)
    private String uid;

    @ManyToOne
    private WorkplaceInformation workplaceInformation;

    @Builder
    public RegisterIp(String ip, String uid, WorkplaceInformation workplaceInformation){
        this.ip = ip;
        this.uid = uid;
        this.workplaceInformation = workplaceInformation;
    }
}

package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
@Table(name = "subscribeInformation")
public class SubscribeInformationE {
    @Id
    private int id;

    @Column(length = 255)
    private String uid;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String providerId;

    @Column(length = 255)
    private String productId;

    private LocalDate endDate;

    private LocalDate nextPaymentDate;

    private LocalDate paymentDate;

    private LocalDate startDate;

    @Builder
    public SubscribeInformationE(String uid, String name, String providerId,
                                 String productId, LocalDate endDate, LocalDate nextPaymentDate,
                                 LocalDate paymentDate, LocalDate startDate){
        this.uid = uid;
        this.name = name;
        this.providerId = providerId;
        this.productId = productId;
        this.endDate = endDate;
        this.nextPaymentDate = nextPaymentDate;
        this.paymentDate = paymentDate;
        this.startDate = startDate;
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.ibatis.annotations.Many;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaAuditing
public class SubscribeInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    public SubscribeInformation(String uid, String name, String providerId,
                                String productId, LocalDate endDate, LocalDate nextPaymentDate,
                                LocalDate paymentDate, LocalDate startDate,
                                WorkplaceInformation workplaceInformation){
        this.uid = uid;
        this.name = name;
        this.providerId = providerId;
        this.productId = productId;
        this.endDate = endDate;
        this.nextPaymentDate = nextPaymentDate;
        this.paymentDate = paymentDate;
        this.startDate = startDate;
        this.workplaceInformation = workplaceInformation;
    }

    @ManyToOne

    private WorkplaceInformation workplaceInformation;
}

package com.example.demo.entity;

import com.example.demo.dto.SubscribeInformationDTO;
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
@Table(name = "SubscribeInformation")
public class SubscribeInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 150)
    private Integer id;

    @Column(length = 255)
    private String uid;

    @Column(length = 255)
    private String name;

    private LocalDate endDate;

    private LocalDate nextPaymentDate;

    private LocalDate paymentDate;

    private LocalDate startDate;

    @Builder
    public SubscribeInformation(String uid, String name, LocalDate endDate,
                                LocalDate nextPaymentDate,
                                LocalDate paymentDate, LocalDate startDate,
                                WorkplaceInformation workplaceInformation,
                                Product product,
                                Provider provider){
        this.uid = uid;
        this.name = name;
        this.endDate = endDate;
        this.nextPaymentDate = nextPaymentDate;
        this.paymentDate = paymentDate;
        this.startDate = startDate;
        this.workplaceInformation = workplaceInformation;
        this.product = product;
        this.provider = provider;
    }

    @ManyToOne
    private WorkplaceInformation workplaceInformation;

    @ManyToOne
    private Provider provider;

    @ManyToOne
    private Product product;

    public static SubscribeInformation toEntity(SubscribeInformationDTO dto, Provider provider, Product product){
        return SubscribeInformation.builder()
                .uid(dto.getUid())
                .name(dto.getName())
                .endDate(dto.getEndDate())
                .nextPaymentDate(dto.getNextPaymentDate())
                .paymentDate(dto.getPaymentDate())
                .startDate(dto.getStartDate())
                .product(product)
                .provider(provider)
                .build();
    }
}

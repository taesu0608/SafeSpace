package com.example.demo.dto;

import com.example.demo.entity.SubscribeInformation;
import lombok.*;

import java.time.LocalDate;

@ToString
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeInformationDTO {
    private Integer id;
    private String uid;
    private String name;
    private String providerId;
    private String productId;
    private LocalDate endDate;
    private LocalDate nextPaymentDate;
    private LocalDate paymentDate;
    private LocalDate startDate;


    public static SubscribeInformationDTO toDTO(SubscribeInformation entity) {
        return SubscribeInformationDTO.builder()
                .id(entity.getId())
                .uid(entity.getUid())
                .name(entity.getName())
                .providerId(entity.getProvider().getProvider_id())
                .productId(entity.getProduct().getProduct_id())
                .endDate(entity.getEndDate())
                .nextPaymentDate(entity.getNextPaymentDate())
                .paymentDate(entity.getPaymentDate())
                .startDate(entity.getStartDate())
                .build();
    }
}

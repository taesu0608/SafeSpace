package com.example.demo.dto;

import com.example.demo.entity.Product;
import lombok.*;

import java.math.BigInteger; // Assuming price is a large integer

@ToString
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String productId;
    private String productName;
    private String providerId;
    private String imgPath;
    private String category;
    private String description;
    private Integer capacity;
    private Integer month;
    private Integer price;

    public static ProductDTO toDTO(Product entity) {
        return ProductDTO.builder()
                .productId(entity.getProductId())
                .productName(entity.getProductName())
                .imgPath(entity.getImgPath())
                .category(entity.getCategory())
                .description(entity.getDescription())
                .capacity(entity.getCapacity())
                .month(entity.getMonth())
                .price(entity.getPrice())
                .providerId(entity.getProvider().getProviderId())
                .build();
    }
}

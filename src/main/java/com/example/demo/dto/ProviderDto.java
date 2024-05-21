package com.example.demo.dto;

import com.example.demo.entity.Product;
import lombok.*;

@ToString
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDto {

    private String providerId;
    private String name;
    private String imgPath;

    public static ProviderDto toDTO(Product entity) {
        return ProviderDto.builder()
                .providerId(entity.getProductId())
                .name(entity.getProductName())
                .imgPath(entity.getImgPath())
                .build();
    }
}
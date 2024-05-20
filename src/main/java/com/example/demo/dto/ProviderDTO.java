package com.example.demo.dto;

import com.example.demo.entity.Product;
import lombok.*;

@ToString
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDTO {

    private String providerId;
    private String name;
    private String img_path;

    public static ProviderDTO toDTO(Product entity) {
        return ProviderDTO.builder()
                .providerId(entity.getProduct_id())
                .name(entity.getProduct_name())
                .img_path(entity.getImg_path())
                .build();
    }
}
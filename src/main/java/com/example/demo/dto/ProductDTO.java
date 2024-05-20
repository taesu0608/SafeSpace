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
    private String imgPath;
    private String category;
    private String description;
    private Integer capacity;
    private Integer month;
    private Integer price;

    public static ProductDTO toDTO(Product entity) {
        return ProductDTO.builder()
                .productId(entity.getProduct_id())
                .productName(entity.getProduct_name())
                .imgPath(entity.getImg_path())
                .category(entity.getCategory())
                .description(entity.getDescription())
                .capacity(entity.getCapacity())
                .month(entity.getMonth())
                .price(entity.getPrice())
                .build();
    }
}

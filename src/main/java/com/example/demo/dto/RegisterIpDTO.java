package com.example.demo.dto;

import com.example.demo.entity.RegisterIp;
import lombok.*;

@ToString
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterIpDTO {
    private String ip;
    private String uid;

    public static RegisterIpDTO toDTO(RegisterIp entity) {
        return RegisterIpDTO.builder()
                .ip(entity.getIp())
                .uid(entity.getUid())
                .build();
    }
}

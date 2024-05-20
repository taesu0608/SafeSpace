package com.example.demo.entity;

import com.example.demo.dto.RegisterIpDTO;
import jakarta.persistence.*;
import lombok.*;
import org.apache.ibatis.annotations.Many;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@Setter
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

    public static RegisterIp toEntity(RegisterIpDTO dto, WorkplaceInformation workplaceInformation){
        return RegisterIp.builder()
                .ip(dto.getIp())
                .uid(dto.getUid())
                .workplaceInformation(workplaceInformation)
                .build();
    }
}

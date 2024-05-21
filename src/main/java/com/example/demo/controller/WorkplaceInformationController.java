package com.example.demo.controller;

import com.example.demo.dto.WorkplaceInformationDto;
import com.example.demo.entity.WorkplaceInformation;
import com.example.demo.service.WorkplaceInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController //JSON 형태로 반환하는 컨트롤러
@RequestMapping("/workplace")
@RequiredArgsConstructor
public class WorkplaceInformationController {
    private final WorkplaceInformationService workplaceInformationService;

    @GetMapping("/user/") //사용자 조회
    public WorkplaceInformationDto getdWorkplaceInformationByUid(@RequestParam("uid") String uid) {
        return new WorkplaceInformationDto().toDTO(
                workplaceInformationService.getWorkplaceInformation(uid)
        );
    }

    @GetMapping("/join/") //회원가입
    public Boolean joinWorkplace(@RequestBody WorkplaceInformationDto workplaceInformationDTO) {
        String uid = workplaceInformationDTO.getUid();
        if(workplaceInformationService.getWorkplaceInformation(uid) == null) return false;

        WorkplaceInformation workplaceInformation = WorkplaceInformation.toEntity(workplaceInformationDTO);
        workplaceInformation.setJoinDate(LocalDate.now());

        workplaceInformationService.saveWorkplaceInformation(workplaceInformation);
        return true;
    }

}

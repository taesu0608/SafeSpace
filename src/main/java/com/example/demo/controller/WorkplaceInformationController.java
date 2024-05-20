package com.example.demo.controller;

import com.example.demo.dto.WorkplaceInformationDTO;
import com.example.demo.entity.WorkplaceInformation;
import com.example.demo.service.WorkplaceInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController //JSON 형태로 반환하는 컨트롤러
@RequestMapping("/workplace")
@RequiredArgsConstructor
public class WorkplaceInformationController {
    private final WorkplaceInformationService workplaceInformationService;

    @GetMapping("/user/") //사용자 조회
    public WorkplaceInformationDTO getdWorkplaceInformationByUid(@RequestParam("uid") String uid) {
        return new WorkplaceInformationDTO().toDTO(
                workplaceInformationService.getWorkplaceInformation(uid)
        );
    }

    @GetMapping("/join/") //회원가입
    public Boolean joinWorkplace(@RequestBody WorkplaceInformationDTO workplaceInformationDTO) {
        String uid = workplaceInformationDTO.getUid();
        if(workplaceInformationService.getWorkplaceInformation(uid) == null) return false;

        WorkplaceInformation workplaceInformation = WorkplaceInformation.toEntity(workplaceInformationDTO);
        workplaceInformation.setJoinDate(LocalDate.now());

        workplaceInformationService.saveWorkplaceInformation(workplaceInformation);
        return true;
    }

}

package com.example.demo.controller;

import com.example.demo.dto.WorkplaceInformationDto;
import com.example.demo.entity.WorkplaceInformation;
import com.example.demo.service.WorkplaceInformationService;
import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController //JSON 형태로 반환하는 컨트롤러
@RequestMapping("/workplace")
@RequiredArgsConstructor
public class WorkplaceInformationController {
    private final WorkplaceInformationService workplaceInformationService;
    private final ServletRequest httpServletRequest;

    @PostMapping("/find/") //사용자 조회
    public WorkplaceInformationDto getdWorkplaceInformationByUid(@RequestParam("uid") String uid) {
        return new WorkplaceInformationDto().toDTO(
                workplaceInformationService.getWorkplaceInformation(uid)
        );
    }

    @PostMapping("/exist/")
    public Boolean existWorkplaceInformationByUid(@RequestParam("uid") String uid) {
        return workplaceInformationService.exsitWorkplaceInformation(uid);
    }

    @PostMapping("/join/") //회원가입
    public Boolean joinWorkplace(@RequestBody WorkplaceInformationDto workplaceInformationDTO) {
        String uid = workplaceInformationDTO.getUid();
        System.out.println(uid);

        if(workplaceInformationService.exsitWorkplaceInformation(uid)) return false; //이미 회원이라면

        WorkplaceInformation workplaceInformation = WorkplaceInformation.toEntity(workplaceInformationDTO);
        workplaceInformation.setWorkspaceIp(httpServletRequest.getRemoteAddr());
        workplaceInformationService.saveWorkplaceInformation(workplaceInformation);
        return true;
    }

}

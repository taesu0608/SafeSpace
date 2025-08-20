package com.example.demo.workInformation.service;

import com.example.demo.workInformation.entity.WorkplaceInformation;
import com.example.demo.workInformation.repository.WorkplaceInformationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkplaceInformationService {
    private final WorkplaceInformationRepo workplaceInformationRepo;

    public WorkplaceInformation getWorkplaceInformation(String uid) {
        Optional<WorkplaceInformation> workplaceInformation = workplaceInformationRepo.findById(uid);
        if(workplaceInformation.isPresent())
            return workplaceInformation.get();
        else
            return null;
    }

    public void saveWorkplaceInformation(WorkplaceInformation workplaceInformation) {
        workplaceInformationRepo.save(workplaceInformation);
    }

    public Boolean exsitWorkplaceInformation(String uid) {
        return workplaceInformationRepo.existsById(uid);
    }
}

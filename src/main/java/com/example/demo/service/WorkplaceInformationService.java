package com.example.demo.service;

import com.example.demo.entity.RegisterIp;
import com.example.demo.entity.WorkplaceInformation;
import com.example.demo.repository.WorkplaceInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkplaceInformationService {
    private final WorkplaceInformationRepository workplaceInformationRepository;

    public WorkplaceInformation getWorkplaceInformation(String uid) {
        Optional<WorkplaceInformation> workplaceInformation = workplaceInformationRepository.findById(uid);
        if(workplaceInformation.isPresent())
            return workplaceInformation.get();
        else
            return null;
    }

    public void saveWorkplaceInformation(WorkplaceInformation workplaceInformation) {
        workplaceInformationRepository.save(workplaceInformation);
    }
}

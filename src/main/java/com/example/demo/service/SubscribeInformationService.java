package com.example.demo.service;

import com.example.demo.entity.SubscribeInformation;
import com.example.demo.repository.SubscribeInformationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscribeInformationService {
    private final SubscribeInformationRepo subscribeInformationRepo;

    public List<SubscribeInformation> getAllSubscribeInformation() {
        return subscribeInformationRepo.findAll();
    }

    public SubscribeInformation getSubscribeInformationById(Integer id) {
        Optional<SubscribeInformation> subscribeInformation =  subscribeInformationRepo.findById(id);
        if(subscribeInformation.isPresent()) {
            return subscribeInformation.get();
        }else
            return null;
    }

    //TODO uid 조회 구현 예정
//    public List<SubscribeInformation> getSubscribeInformationByUid(String uid) {
//
//    }
}

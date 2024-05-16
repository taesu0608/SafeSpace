package com.example.demo.service;

import com.example.demo.entity.SubscribeInformation;
import com.example.demo.repository.SubscribeInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscribeInformationService {
    private final SubscribeInformationRepository subscribeInformationRepository;

    public List<SubscribeInformation> getAllSubscribeInformation() {
        return subscribeInformationRepository.findAll();
    }

    public SubscribeInformation getSubscribeInformationById(Integer id) {
        Optional<SubscribeInformation> subscribeInformation =  subscribeInformationRepository.findById(id);
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

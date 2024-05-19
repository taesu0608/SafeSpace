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

    //모든 구독 상황 조회
    public List<SubscribeInformation> getAllSubscribeInformation() {
        return subscribeInformationRepository.findAll();
    }

    //상품 검색
    public SubscribeInformation getSubscribeInformationById(Integer id) {
        Optional<SubscribeInformation> subscribeInformation =  subscribeInformationRepository.findById(id);
        if(subscribeInformation.isPresent()) {
            return subscribeInformation.get();
        }else
            return null;
    }

    //uid 조회
    public List<SubscribeInformation> getSubscribeInformationByUid(String uid) {
        return subscribeInformationRepository.findByUid(uid);
    }

    //저장
    public void saveSubscribeInformation(SubscribeInformation subscribeInformation) {
        subscribeInformationRepository.save(subscribeInformation);
    }


}

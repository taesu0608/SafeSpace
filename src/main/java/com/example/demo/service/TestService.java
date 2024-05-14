package com.example.demo.service;

import com.example.demo.entity.Test;
import com.example.demo.repository.TestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    //Build방식을 통한 생성자 주입
    Test testEntity = Test.builder()
            .testContents("2")
            .build();

    public void save(){
        //영속성 부여
        testRepository.save(testEntity);
        List<Test> testList = testRepository.findAll();
    }

}

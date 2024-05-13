package com.example.demo.service;

import com.example.demo.dto.TestDto;
import com.example.demo.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public TestDto testServiceMethod(String str) {
        TestDto testDto = new TestDto(str);

        return testDto;
    }
}
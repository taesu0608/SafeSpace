package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProviderDto;
import com.example.demo.entity.Provider;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProviderRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {

    @Autowired
    private ProviderRepo providerRepo;
    @Autowired
    private ProductRepo productRepo;

    @SneakyThrows//상위로 예외던짐
    public ArrayList<ProviderDto> providerInit() {
        String str = "";
        String sb = "";
        ClassPathResource resource = null;
        InputStreamReader reader = null;

        //static폴더의 json파일을 string으로 저장
        try {
            resource = new ClassPathResource("static/provider.json");
            reader = new InputStreamReader(resource.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            while ((str = br.readLine()) != null) {
                sb += str + "\n";
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        //String(json)을 Object로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        //ProviderDto provider = objectMapper.readValue(sb, ProviderDto.class);

        //Json Array일 경우 사용
        ArrayList<ProviderDto> provider = objectMapper.readValue(sb,new TypeReference<ArrayList<ProviderDto>>(){});
        return provider;
    }
    public void saveProvider(Provider provider) { providerRepo.save(provider);}

    //모든 컨텐츠 제공자 불러오기
    public List<Provider> getAllProviders() {
        return providerRepo.findAll();
    }

    // Todo 카테고리별 컨텐츠 제공자 불러오기
    public List<Provider> getCategory() {
        return providerRepo.findAll();
    }
}

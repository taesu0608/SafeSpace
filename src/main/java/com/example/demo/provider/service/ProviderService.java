package com.example.demo.provider.service;

import com.example.demo.provider.dto.ProviderDto;
import com.example.demo.provider.entity.Provider;
import com.example.demo.product.product.repository.ProductRepo;
import com.example.demo.provider.repository.ProviderRepo;
import com.example.demo.service.InitService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderService {

    @Autowired
    private ProviderRepo providerRepo;
    @Autowired
    private ProductRepo productRepo;

    @SneakyThrows//상위로 예외던짐
    public ArrayList<ProviderDto> providerInit() {
     ObjectMapper objectMapper = new ObjectMapper();
        //ProviderDto provider = objectMapper.readValue(sb, ProviderDto.class);

        //Json Array일 경우 사용
        ArrayList<ProviderDto> provider = objectMapper.readValue(
                InitService.resourceJsonToString("provider.json")
                ,new TypeReference<ArrayList<ProviderDto>>(){});
        return provider;
    }
    public void saveProvider(Provider provider) { providerRepo.save(provider);}

    //모든 컨텐츠 제공자 불러오기
    public List<Provider> getAllProviders() {
        return providerRepo.findAll();
    }

    public Provider getProviderById(String id) {
        Optional<Provider> provider = providerRepo.findById(id);
        return provider.isPresent() ? provider.get() : null;
    }

    // Todo 카테고리별 컨텐츠 제공자 불러오기
    public List<Provider> getCategory() {
        return providerRepo.findAll();
    }
}

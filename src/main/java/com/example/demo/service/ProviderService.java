package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProviderDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.Provider;
import com.example.demo.repository.ProviderRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class ProviderService {

    @Autowired
    private ProviderRepo providerRepo;

    @SneakyThrows//상위로 예외던짐
    public Provider providerInit() {
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
        ProviderDto provider = objectMapper.readValue(sb, ProviderDto.class);

        //TODO Json배열형 object 변환
        //ProductDTO[] products = objectMapper.readValue(sb,ProductDTO[].class);
        /*
           for (ProductDTO product : products) {
                productRepo.save( Product.toEntity(product, provider));}
        */
        return Provider.toEntity(provider);
    }

    public void saveProvider(Provider provider) { providerRepo.save(provider);}
}

package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.Provider;
import com.example.demo.repository.ProductRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.*;
import java.io.InputStreamReader;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepo productRepo;

    @SneakyThrows//상위로 예외던짐
    public ArrayList<ProductDto> productInit() {
        String str = "";
        String sb = "";
        ClassPathResource resource = null;
        InputStreamReader reader = null;

        //static폴더의 json파일을 string으로 저장
        try {
            resource = new ClassPathResource("static/product.json");
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
        
        //Json Object일 경우 사용
        /*ProductDto product = objectMapper.readValue(sb, ProductDto.class);*/

        //Json Array일 경우 사용
        ArrayList<ProductDto> products = objectMapper.readValue(sb,new TypeReference<ArrayList<ProductDto>>(){});

        return products;
    }
    
    //개별 상품 저장
    public void saveProduct(Product product) {productRepo.save(product);}
    
    //모든 상품 저장
    public void saveAllProduct(Product product) {
        productRepo.save(product);
    }

    //모든 상품 조회
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    //개별 상품 조회
    public Product getProductById(String productId) {
        Optional<Product> product =  productRepo.findById(productId);
        if(product.isPresent()) {
            return product.get();
        }else
            return null;
    }
}


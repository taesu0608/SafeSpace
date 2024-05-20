package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepo productRepo;

    public Product productUpdate() {
        String str = "";
        String sb = "";
        ClassPathResource resource = null;
        InputStreamReader reader = null;

        try{
            resource = new ClassPathResource("static/product.json");
            reader = new InputStreamReader(resource.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            while ((str = br.readLine()) != null) {

                System.out.println(str); sb += str + "\n";

            }
        }catch(IOException e){
            System.out.println(e);
        }

        Gson gson = new Gson();
        Product product = gson.fromJson(str,Product.class);

        System.out.println(product);

        return product;
    }
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

}

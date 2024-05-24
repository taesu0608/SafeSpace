package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProviderDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.Provider;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProviderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitService implements CommandLineRunner {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProviderRepo providerRepo;

    @Override
    public void run(String... args) throws Exception {
        InitDB();
    }

    public void InitDB() {
        ArrayList<Provider> providers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        Provider providerEntity;
        for (ProviderDto pv : providerService.providerInit()) {
            providerEntity = Provider.toEntity(pv);
            for (ProductDto p : productService.productInit()) {
                log.info(p.getProviderId());
                log.info(pv.getProviderId());
                if(p.getProviderId().equals(pv.getProviderId()))products.add(Product.toEntity(p,providerEntity));
            }
            providers.add(providerEntity);
        }
        providerRepo.saveAll(providers);
        productRepo.saveAll(products);
    }
}

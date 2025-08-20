package com.example.demo.product.category.service;

import com.example.demo.product.category.dto.ProviderCategoryDto;
import com.example.demo.product.category.entity.Category;
import com.example.demo.provider.entity.Provider;
import com.example.demo.product.category.entity.ProviderCategory;
import com.example.demo.product.category.repository.ProviderCategoryRepo;
import com.example.demo.service.InitService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderCategoryService {
    private final ProviderCategoryRepo providerCategoryRepo;

    public void saveProviderCategory(ProviderCategory providerCategory) {
        providerCategoryRepo.save(providerCategory);
    }

    public List<ProviderCategory> getAllProviderCategory() {
        return providerCategoryRepo.findAll();
    }

    public List<ProviderCategory> getProviderCategoryByCategory(Category category) {
        return providerCategoryRepo.findByCategory(category);
    }

    public List<ProviderCategory> getProviderCategoryByProvider(Provider provider) {
        return providerCategoryRepo.findByProvider(provider);
    }

    @SneakyThrows
    public ArrayList<ProviderCategoryDto> providerCategoryInit(){
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                InitService.resourceJsonToString("provider_category.json")
                , new TypeReference<ArrayList<ProviderCategoryDto>>() {});
    }
}

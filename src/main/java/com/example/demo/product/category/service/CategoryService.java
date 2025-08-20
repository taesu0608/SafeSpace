package com.example.demo.product.category.service;

import com.example.demo.product.category.dto.CategoryDto;
import com.example.demo.product.category.entity.Category;
import com.example.demo.product.category.repository.CategoryRepo;
import com.example.demo.service.InitService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public void saveCategory(Category category) {categoryRepo.save(category);}

    public List<Category> findAll() {return categoryRepo.findAll(); }

    public Category getCategory(String id) {
        Optional<Category> category = categoryRepo.findById(id);
        if(category.isPresent()) {return category.get();}
        return null;
    }

    @SneakyThrows
    public ArrayList<CategoryDto> categoryInit(){
        ObjectMapper objectMapper = new ObjectMapper();

        //Json Array일 경우 사용
        ArrayList dtos = objectMapper.readValue(InitService.resourceJsonToString("category.json"),new TypeReference<ArrayList<CategoryDto>>(){});
        return dtos;
    }
}
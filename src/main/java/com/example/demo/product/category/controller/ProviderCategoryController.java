package com.example.demo.product.category.controller;

import com.example.demo.product.category.dto.ProviderCategoryDto;
import com.example.demo.product.category.entity.ProviderCategory;
import com.example.demo.product.category.service.ProviderCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //JSON 형태로 반환하는 컨트롤러
@RequestMapping("/provider_category")
@RequiredArgsConstructor
public class ProviderCategoryController {
    private final ProviderCategoryService providerCategoryService;

    //모든 Product카테고리 조회
    @GetMapping("/findAll/")
    public List<ProviderCategoryDto> findAll() {
        List<ProviderCategory> list = providerCategoryService.getAllProviderCategory();
        ArrayList<ProviderCategoryDto> rst = new ArrayList<>();

        for (ProviderCategory providerCategory : list)
            rst.add(ProviderCategoryDto.toDto(providerCategory));

        return rst;
    }
}

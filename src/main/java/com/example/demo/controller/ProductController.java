package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //JSON 형태로 반환하는 컨트롤러
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    //모든 Product 조회
    @GetMapping("/get/")
    public List<ProductDto> getProduct() {
        ArrayList<ProductDto> dtos = new ArrayList<>();
        for (Product p : productService.getAllProduct()) {
            dtos.add(new ProductDto().toDTO(p));
        }
        return dtos;
    }

    //개별 Product 조회
    @GetMapping("/get2/")
    public ProductDto getProductById(@RequestParam("productId") String productId) {
        return new ProductDto().toDTO(
                productService.getProductById(productId)
        );
    }
}

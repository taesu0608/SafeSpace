package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProviderCategoryDto;
import com.example.demo.dto.ProviderDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.Provider;
import com.example.demo.entity.ProviderCategory;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProviderCategoryRepo;
import com.example.demo.repository.ProviderRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    
    private final CategoryService categoryService;
    private final CategoryRepo categoryRepo;

    private final ProviderCategoryService providerCategoryService;
    private final ProviderCategoryRepo providerCategoryRepo;
    @Override
    public void run(String... args) throws Exception {
      InitDB();
    }

    public void InitDB() {
        ArrayList<Provider> providers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        for(CategoryDto dto : categoryService.categoryInit()) {
           categoryService.saveCategory(Category.toEntity(dto));
        }


        Provider providerEntity;
        ProviderCategory pc;
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
        
        //provider_category matching
        for(ProviderCategoryDto dto : providerCategoryService.providerCategoryInit()) {
            providerCategoryService.saveProviderCategory(
                    ProviderCategory.toEntity(
                            Provider.toEntity(dto.getProvider()),
                            Category.toEntity(dto.getCategory())
                    )
            );
        }
    }

    @SneakyThrows//상위로 예외던짐
    public static String resourceJsonToString(String path){
        String str = "";
        String sb = "";
        ClassPathResource resource = null;
        InputStreamReader reader = null;

        //static폴더의 json파일을 string으로 저장
        try {
            resource = new ClassPathResource("static/" + path);
            reader = new InputStreamReader(resource.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            while ((str = br.readLine()) != null) {
                sb += str + "\n";
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return sb;


    }
}

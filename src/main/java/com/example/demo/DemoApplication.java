package com.example.demo;

import com.example.demo.entity.Product;
import com.example.demo.entity.Provider;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.ProviderRepo;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//로그인 (security 배제)
@RestController
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class DemoApplication {
	@Autowired
	ProductService productService;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	ProviderRepo providerRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//localhost:8080를 호출하면 helloWorld를 찍어주기 위한 함수
	@RequestMapping("/")
	public String helloWorld(){
		//TODo provider json 파일 후 init메서드 작성
		Provider provider = Provider.builder()
				.providerId("a")
				.name("abc")
				.imgPath("asc")
				.build();
		providerRepo.save(provider);
		productService.productInit(provider);
		return "helloW나야d12345";
	}

}

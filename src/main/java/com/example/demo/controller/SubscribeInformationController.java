package com.example.demo.controller;

import com.example.demo.dto.SubscribeInformationDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.Provider;
import com.example.demo.entity.SubscribeInformation;
import com.example.demo.entity.WorkplaceInformation;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProviderService;
import com.example.demo.service.SubscribeInformationService;
import com.example.demo.service.WorkplaceInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController //JSON 형태로 반환하는 컨트롤러
@RequestMapping("/subscribe_info")
@RequiredArgsConstructor
public class SubscribeInformationController {
    private final SubscribeInformationService subscribeInformationService;
    private final ProductService productService;
    private final ProviderService providerService;
    private final WorkplaceInformationService workplaceInformationService;

    //모든 구독 정보 조회
    @GetMapping("/getAll/")
    public List<SubscribeInformation> getAllSubscribeInformation() {
        return subscribeInformationService.getAllSubscribeInformation();
    }

    //구독 정보 추가
    @PostMapping("/add/")
    public Boolean addSubscribeInformation(@RequestParam("uid") String uid,
                                           @RequestParam("productId") String productId) {
        Product product = productService.getProductById(productId);
        Provider provider = product.getProvider();
        WorkplaceInformation workplaceInformation = workplaceInformationService.getWorkplaceInformation(uid);
        SubscribeInformation subscribeInformation = new SubscribeInformation(uid, null, null, null,
                null, null, workplaceInformation, product, provider);

        subscribeInformationService.saveSubscribeInformation(
                SubscribeInformation.toEntity(
                        new SubscribeInformationDto().toDTO(subscribeInformation),
                        provider,
                        product
                )
        );

        return true;
    }

    //id 조회
    @GetMapping("/find/")
    public SubscribeInformationDto getSubscribeInformationById(@RequestParam("id") Integer id) {
        return new SubscribeInformationDto().toDTO(
                subscribeInformationService.getSubscribeInformationById(id)
        );
    }

    //uid 조회
    @PostMapping("/findByUid/")
    public List<SubscribeInformationDto> getSubscribeInformationByUid(@RequestParam("uid") String uid) {
        ArrayList<SubscribeInformation> subscribeInformations
                = (ArrayList<SubscribeInformation>) subscribeInformationService.getSubscribeInformationByUid(uid);

        ArrayList<SubscribeInformationDto> dtos = new ArrayList<>();
        for(SubscribeInformation subscribeInformation : subscribeInformations) {
            dtos.add(new SubscribeInformationDto().toDTO(subscribeInformation));
        }

        return dtos;
    }
}

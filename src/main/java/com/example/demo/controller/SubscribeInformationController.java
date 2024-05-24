package com.example.demo.controller;

import com.example.demo.dto.SubscribeInformationDto;
import com.example.demo.entity.SubscribeInformation;
import com.example.demo.service.SubscribeInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController //JSON 형태로 반환하는 컨트롤러
    @RequestMapping("/subscribe_info")
@RequiredArgsConstructor
public class SubscribeInformationController {
    private final SubscribeInformationService subscribeInformationService;
    //private final ProductService productService;
    //private final ProviderService providerService;

    //구독 상품 추가
    //TODO ProductService, ProviderService 가 만들어진 후 작성
    @PostMapping("/add/")
    public Boolean addSubscribeInformation(@RequestParam("uid") String uid,
                                           @RequestParam("productId") String productId) {
//        subscribeInformationService.saveSubscribeInformation(
//                SubscribeInformation.toEntity(
//                        subscribeInformation,
//
//                )
//        );

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

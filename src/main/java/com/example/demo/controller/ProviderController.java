
package com.example.demo.controller;

import com.example.demo.service.ProviderService;
import com.example.demo.entity.Provider;
import com.example.demo.dto.ProviderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //JSON 형태로 반환하는 컨트롤러
@RequestMapping("/provider")
@RequiredArgsConstructor
public class ProviderController {

    @Autowired
    ProviderService providerService;

    //모든 Provider 조회
    @GetMapping("/findAll/")
    public List<ProviderDto> getProvider() {
        ArrayList<ProviderDto> dtos = new ArrayList<>();
        for (Provider p : providerService.getAllProviders()) {
            dtos.add(new ProviderDto().toDTO(p));

        }
        return dtos;
    }
}

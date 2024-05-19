package com.example.demo.service;

import com.example.demo.entity.RegisterIp;
import com.example.demo.repository.RegisterIpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterIpService {
    private final RegisterIpRepository registerIpRepository;

    public List<RegisterIp> getRegisterIpList() {
        return registerIpRepository.findAll();
    }

    public RegisterIp getRegisterIpByIp(String ip) {
        Optional<RegisterIp> registerIp = registerIpRepository.findById(ip);
        if(registerIp.isPresent())
            return registerIp.get();
        else
            return null;
    }

    public void saveRegisterIp(RegisterIp registerIp) {
        registerIpRepository.save(registerIp);
    }
}

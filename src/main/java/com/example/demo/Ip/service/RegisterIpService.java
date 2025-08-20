package com.example.demo.Ip.service;

import com.example.demo.Ip.entity.RegisterIp;
import com.example.demo.Ip.repository.RegisterIpRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterIpService {
    private final RegisterIpRepo registerIpRepo;

    public List<RegisterIp> getRegisterIpList() {
        return registerIpRepo.findAll();
    }

    public RegisterIp getRegisterIpByIp(String ip) {
        Optional<RegisterIp> registerIp = registerIpRepo.findById(ip);
        if(registerIp.isPresent())
            return registerIp.get();
        else
            return null;
    }

    public void saveRegisterIp(RegisterIp registerIp) {
        registerIpRepo.save(registerIp);
    }
}

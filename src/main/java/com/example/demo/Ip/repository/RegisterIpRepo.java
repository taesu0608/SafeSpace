package com.example.demo.Ip.repository;

import com.example.demo.Ip.entity.RegisterIp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterIpRepo extends JpaRepository<RegisterIp,String> {
    Optional<RegisterIp> findById(String id);
}

package com.example.demo.subscribe.repository;

import com.example.demo.subscribe.entity.SubscribeInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribeInformationRepo extends JpaRepository<SubscribeInformation, Integer> {
    List<SubscribeInformation> findByUid(String uid);
}

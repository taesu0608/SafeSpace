package com.example.demo.repository;

import com.example.demo.entity.SubscribeInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscribeInformationRepository extends JpaRepository<SubscribeInformation, Integer> {
}

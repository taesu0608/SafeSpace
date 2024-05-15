package com.example.demo.repository;

import com.example.demo.entity.SubscribeInformation;
import com.example.demo.entity.TestE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscribeInformationRepository extends JpaRepository<SubscribeInformation, Integer> {
    Optional<SubscribeInformation> findById(Integer id);
}

package com.example.demo.repository;

import com.example.demo.model.entity.CustomerEntity;
import com.example.demo.model.entity.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DealRepository extends JpaRepository<DealEntity, UUID> {
}

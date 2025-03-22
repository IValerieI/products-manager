package com.example.demo.repository;

import com.example.demo.model.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SupplyRepository extends JpaRepository<SupplyEntity, UUID> {

    @Override
    List<SupplyEntity> findAll();
}

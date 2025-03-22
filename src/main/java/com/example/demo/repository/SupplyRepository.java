package com.example.demo.repository;

import com.example.demo.model.entity.SupplyEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SupplyRepository extends JpaRepository<SupplyEntity, UUID> {

    List<SupplyEntity> findAll();

    List<SupplyEntity> findAll(Specification<SupplyEntity> specification);
}

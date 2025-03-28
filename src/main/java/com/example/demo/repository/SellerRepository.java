package com.example.demo.repository;

import com.example.demo.model.entity.SellerEntity;
import com.example.demo.model.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerRepository extends JpaRepository<SellerEntity, UUID> {
}

package com.example.demo.repository;

import com.example.demo.model.entity.PriceHistoryEntity;
import com.example.demo.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PriceHistoryRepository extends JpaRepository<PriceHistoryEntity, UUID> {

    @Query("""
           SELECT p
           FROM PriceHistoryEntity p
           WHERE p.productEntity=:productEntity
           ORDER BY p.startDate DESC
           LIMIT 1
           """)
    PriceHistoryEntity findLatestPriceByProduct(@Param("productEntity") ProductEntity productEntity);
}

package com.example.demo.mapper;

import com.example.demo.model.dto.response.SupplyResponse;
import com.example.demo.model.entity.*;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class SupplyMapper {

    public abstract SupplyResponse mapToSupplyResponse(SupplyEntity supplyEntity);

    @Transactional
    public SupplyEntity mapToSupplyEntity(SellerEntity sellerEntity, CustomerEntity customerEntity, DealEntity dealEntity,
                                          double weight, LocalDate dealDate, ProductEntity productEntity) {
        return SupplyEntity.builder()
                .id(UUID.randomUUID())
                .sellerEntity(sellerEntity)
                .customerEntity(customerEntity)
                .dealEntity(dealEntity)
                .productEntity(productEntity)
                .pricePaid(productEntity.getCurrentPrice())
                .weight(weight)
                .date(dealDate)
                .build();
    };
}

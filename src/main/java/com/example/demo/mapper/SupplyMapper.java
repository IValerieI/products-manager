package com.example.demo.mapper;

import com.example.demo.model.dto.response.SupplyResponse;
import com.example.demo.model.entity.CustomerEntity;
import com.example.demo.model.entity.DealEntity;
import com.example.demo.model.entity.ProductEntity;
import com.example.demo.model.entity.SellerEntity;
import com.example.demo.model.entity.SupplyEntity;
import jakarta.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class SupplyMapper {

    @Mapping(target = "name", source = "productEntity.name")
    public SupplyResponse mapToSupplyResponse(SupplyEntity supplyEntity) {
        return SupplyResponse.builder()
                .weight(supplyEntity.getWeight())
                .pricePaid(supplyEntity.getPricePaid())
                .name(supplyEntity.getProductEntity().getName())
                .cost(supplyEntity.getPricePaid().multiply(BigDecimal.valueOf(supplyEntity.getWeight())))
                .build();
    }

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
    }
}

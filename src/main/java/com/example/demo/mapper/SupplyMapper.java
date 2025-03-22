package com.example.demo.mapper;

import com.example.demo.model.dto.response.SupplyResponse;
import com.example.demo.model.entity.SupplyEntity;
import com.example.demo.service.SupplyService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplyMapper {

    SupplyResponse mapToSupplyResponse(SupplyEntity supplyEntity);
}

package com.example.demo.mapper;

import com.example.demo.model.dto.response.ProcessedDealResponse;
import com.example.demo.model.entity.DealEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DealMapper {

    ProcessedDealResponse mapToProcessedDealResponse(DealEntity dealEntity);
}

package com.example.demo.service.impl;

import com.example.demo.mapper.SupplyMapper;
import com.example.demo.model.dto.response.SupplyResponse;
import com.example.demo.model.entity.SupplyEntity;
import com.example.demo.repository.SupplyRepository;
import com.example.demo.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository supplyRepository;
    private final SupplyMapper supplyMapper;

    @Override
    public List<SupplyResponse> getSupplies() {
        return supplyRepository.findAll().stream()
                .map(supplyMapper::mapToSupplyResponse)
                .toList();
    }
}

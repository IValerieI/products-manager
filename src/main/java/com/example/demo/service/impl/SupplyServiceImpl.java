package com.example.demo.service.impl;

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

    @Override
    public List<SupplyEntity> getSupplies() {
        return supplyRepository.findAll();
    }
}

package com.example.demo.service;

import com.example.demo.model.dto.response.SupplyResponse;

import java.util.List;

public interface SupplyService {

    List<SupplyResponse> getSupplies();
}

package com.example.demo.service;

import com.example.demo.model.dto.request.SupplyReportRequest;
import com.example.demo.model.dto.response.SupplyReportResponse;
import com.example.demo.model.dto.response.SupplyResponse;

import java.util.List;

public interface SupplyService {

    List<SupplyResponse> getSupplies();

    SupplyReportResponse getSupplyReport(SupplyReportRequest request);
}

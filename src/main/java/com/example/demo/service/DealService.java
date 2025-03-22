package com.example.demo.service;

import com.example.demo.model.dto.request.ProcessDealRequest;
import com.example.demo.model.dto.response.ProcessedDealResponse;

public interface DealService {

    ProcessedDealResponse processDeal(ProcessDealRequest request);
}

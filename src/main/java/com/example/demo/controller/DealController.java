package com.example.demo.controller;

import com.example.demo.model.dto.request.ProcessDealRequest;
import com.example.demo.model.dto.response.ProcessedDealResponse;
import com.example.demo.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/deal-management")
public class DealController {

    private final DealService dealService;

    @PostMapping()
    public ResponseEntity<ProcessedDealResponse> createDeal(@RequestBody ProcessDealRequest request) {
        return ResponseEntity.ok(dealService.processDeal(request));
    }
}

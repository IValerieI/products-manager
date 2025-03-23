package com.example.demo.controller;

import com.example.demo.model.dto.request.SupplyReportRequest;
import com.example.demo.model.dto.response.SupplyReportResponse;
import com.example.demo.model.dto.response.SupplyResponse;
import com.example.demo.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/supply-management")
public class SupplyController {

    private final SupplyService supplyService;

    @GetMapping("/supplies")
    public ResponseEntity<List<SupplyResponse>> getSupplyList() {
        return ResponseEntity.ok(supplyService.getSupplies());
    }

    @PostMapping("/report")
    public ResponseEntity<SupplyReportResponse> getSupplyReport(@RequestBody SupplyReportRequest request) {
        return ResponseEntity.ok(supplyService.getSupplyReport(request));
    }
}

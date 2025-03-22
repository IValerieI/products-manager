package com.example.demo.controller;

import com.example.demo.model.dto.response.SupplyResponse;
import com.example.demo.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

package com.example.demo.controller;

import com.example.demo.model.dto.request.UpdateProductPriceRequest;
import com.example.demo.model.dto.response.ProductPriceResponse;
import com.example.demo.service.ProductService;
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
@RequestMapping("/product-management")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductPriceResponse> updatePrice(@RequestBody UpdateProductPriceRequest request) {
        return ResponseEntity.ok(productService.updatePrice(request));
    }
}

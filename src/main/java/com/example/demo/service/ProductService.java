package com.example.demo.service;

import com.example.demo.model.dto.request.UpdateProductPriceRequest;
import com.example.demo.model.dto.response.ProductPriceResponse;

public interface ProductService {

    ProductPriceResponse updatePrice(UpdateProductPriceRequest request);
}

package com.example.demo.service.impl;

import com.example.demo.model.dto.request.UpdateProductPriceRequest;
import com.example.demo.model.dto.response.ProductPriceResponse;
import com.example.demo.model.entity.PriceHistoryEntity;
import com.example.demo.model.entity.ProductEntity;
import com.example.demo.repository.PriceHistoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.demo.util.ExceptionStringUtil.ENTITY_NOT_FOUND;
import static com.example.demo.util.ExceptionStringUtil.PRODUCT_ID;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final PriceHistoryRepository priceHistoryRepository;

    @Override
    public ProductPriceResponse updatePrice(UpdateProductPriceRequest request) {
        ProductEntity productEntity = productRepository
                .findById(UUID.fromString(request.getProductId()))
                .orElseThrow(() -> new EntityNotFoundException(format(
                        ENTITY_NOT_FOUND, PRODUCT_ID, request.getProductId())));

        LocalDateTime currentDate = LocalDateTime.now();
        PriceHistoryEntity oldPriceHistoryEntity = priceHistoryRepository.findLatestPriceByProduct(productEntity);
        oldPriceHistoryEntity.setEndDate(currentDate);
        priceHistoryRepository.save(oldPriceHistoryEntity);

        productEntity.setCurrentPrice(request.getNewPrice());
        productEntity = productRepository.save(productEntity);

        PriceHistoryEntity currentPriceHistoryEntity = priceHistoryRepository.save(new PriceHistoryEntity().toBuilder()
                .id(UUID.randomUUID())
                .productEntity(productEntity)
                .priceArchived(productEntity.getCurrentPrice())
                .startDate(currentDate)
                .build()
        );
        currentPriceHistoryEntity = priceHistoryRepository.save(currentPriceHistoryEntity);
        return  ProductPriceResponse.builder()
                .priceArchived(currentPriceHistoryEntity.getPriceArchived())
                .startDate(currentDate)
                .build();
    }
}

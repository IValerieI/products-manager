package com.example.demo.service.impl;

import com.example.demo.mapper.DealMapper;
import com.example.demo.mapper.SupplyMapper;
import com.example.demo.model.dto.request.ProcessDealRequest;
import com.example.demo.model.dto.response.ProcessedDealResponse;
import com.example.demo.model.entity.CustomerEntity;
import com.example.demo.model.entity.DealEntity;
import com.example.demo.model.entity.SellerEntity;
import com.example.demo.model.entity.SupplyEntity;
import com.example.demo.repository.*;
import com.example.demo.service.DealService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.example.demo.util.ExceptionStringUtil.*;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final SupplyRepository supplyRepository;
    private final DealRepository dealRepository;
    private final SupplyMapper supplyMapper;
    private final DealMapper dealMapper;

    @Override
    @Transactional
    public ProcessedDealResponse processDeal(@NonNull ProcessDealRequest request) {
        SellerEntity sellerEntity = sellerRepository
                .findById(UUID.fromString(request.getSellerId()))
                .orElseThrow(() -> new EntityNotFoundException(format(
                        ENTITY_NOT_FOUND, SELLER_ID, request.getSellerId())));
        CustomerEntity customerEntity = customerRepository
                .findById(UUID.fromString(request.getCustomerId()))
                .orElseThrow(() -> new EntityNotFoundException(format(
                        ENTITY_NOT_FOUND, CUSTOMER_ID, request.getCustomerId())));
        LocalDate dealDate = LocalDate.now();
        DealEntity dealEntity = dealRepository.save(new DealEntity().toBuilder()
                        .id(UUID.randomUUID())
                        .sellerEntity(sellerEntity)
                        .customerEntity(customerEntity)
                        .date(dealDate)
                        .name(request.getName())
                        .build()
        );

        List<SupplyEntity> supplyEntities = request.getSupplies().stream()
                .map(supplyRequest -> supplyMapper.mapToSupplyEntity(
                        sellerEntity,
                        customerEntity,
                        dealEntity,
                        supplyRequest.getWeight(),
                        dealDate,
                        productRepository.findById(UUID.fromString(supplyRequest.getProductId()))
                                .orElseThrow(() -> new EntityNotFoundException(format(
                                        ENTITY_NOT_FOUND, PRODUCT_ID, supplyRequest.getProductId())))
                ))
                .toList();
        supplyRepository.saveAll(supplyEntities);

        ProcessedDealResponse processedDealResponse = dealMapper.mapToProcessedDealResponse(dealEntity);
        processedDealResponse.setDescription("Поступление товаров обработано");
        return processedDealResponse;
    }
}

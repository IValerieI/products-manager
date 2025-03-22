package com.example.demo.service.impl;

import com.example.demo.mapper.SupplyMapper;
import com.example.demo.model.dto.request.SupplyReportRequest;
import com.example.demo.model.dto.response.SupplyReportResponse;
import com.example.demo.model.dto.response.SupplyResponse;
import com.example.demo.model.entity.CustomerEntity;
import com.example.demo.model.entity.ProductEntity;
import com.example.demo.model.entity.SellerEntity;
import com.example.demo.model.entity.SupplyEntity;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SellerRepository;
import com.example.demo.repository.SupplyRepository;
import com.example.demo.repository.specification.SupplySpecification;
import com.example.demo.service.SupplyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.example.demo.util.ExceptionStringUtil.*;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService {

    private final SupplyRepository supplyRepository;
    private final SupplyMapper supplyMapper;
    private final SellerRepository sellerRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Override
    public List<SupplyResponse> getSupplies() {
        return supplyRepository.findAll().stream()
                .map(supplyMapper::mapToSupplyResponse)
                .toList();
    }

    public SupplyReportResponse getSupplyReport(SupplyReportRequest request) {
        SellerEntity sellerEntity = sellerRepository
                .findById(UUID.fromString(request.getSellerId()))
                .orElseThrow(() -> new EntityNotFoundException(format(
                        ENTITY_NOT_FOUND, SELLER_ID, request.getSellerId())));
        CustomerEntity customerEntity = null;
        if (request.getCustomerId() != null) {
            customerEntity = customerRepository
                    .findById(UUID.fromString(request.getCustomerId()))
                    .orElseThrow(() -> new EntityNotFoundException(format(
                            ENTITY_NOT_FOUND, CUSTOMER_ID, request.getCustomerId())));
        }
        ProductEntity productEntity = null;
        if (request.getProductId() != null) {
            productEntity = productRepository
                    .findById(UUID.fromString(request.getProductId()))
                    .orElseThrow(() -> new EntityNotFoundException(format(
                            ENTITY_NOT_FOUND, PRODUCT_ID, request.getProductId())));
        }

        Specification<SupplyEntity> specification = SupplySpecification.getSpecification(
                sellerEntity,
                productEntity,
                customerEntity,
                request.getFromDate(),
                request.getToDate());
        List<SupplyEntity> supplyEntities = supplyRepository.findAll(specification);

        List<SupplyResponse> supplyResponses = supplyEntities.stream()
                .map(supplyMapper::mapToSupplyResponse)
                .toList();

        SupplyReportResponse response = new SupplyReportResponse();
        response.setSupplies(supplyResponses);
        response.setDate(LocalDate.now());
        BigDecimal countCost = supplyResponses.stream()
                .map(SupplyResponse::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        response.setCountCost(countCost.setScale(2, RoundingMode.HALF_UP));
        double weight = supplyResponses.stream()
                        .mapToDouble(SupplyResponse::getWeight).sum();
        response.setCountWeight(weight);
        return response;
    }
}

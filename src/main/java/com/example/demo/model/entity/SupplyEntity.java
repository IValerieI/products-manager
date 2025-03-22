package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supply")
public class SupplyEntity {

    @Id
    private UUID id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "price_paid", nullable = false)
    private BigDecimal pricePaid;

    @Column(name = "weight", nullable = false)
    private double weight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity productEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private SellerEntity sellerEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customerEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deal_id", referencedColumnName = "id", nullable = false)
    private DealEntity dealEntity;
}

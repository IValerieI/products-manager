package com.example.demo.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
public class UpdateProductPriceRequest {

    @UUID(message = "Пример: Идентификатор продукта id = cd874464-19fc-47c5-94c8-34eee9bdae05")
    private String productId;

    @NotNull
    @Positive
    private BigDecimal newPrice;
}

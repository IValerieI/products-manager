package com.example.demo.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UUID;

@Data
@Builder(toBuilder = true)
public class ProcessSupplyRequest {

    @UUID(message = "Идентификатор продукта обязателен, пример id =cd874464-19fc-47c5-94c8-34eee9bdae05")
    @UUID
    private String productId;

    @NotNull
    @Positive(message = "Вес не может быть отрицательным или равным 0")
    private double weight;
}

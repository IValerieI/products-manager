package com.example.demo.model.dto.request;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class SupplyReportRequest {

    @UUID(message = "Идентификатор продавца обязателен, пример id = cd874464-19fc-47c5-94c8-34eee9bdae05")
    private String sellerId;

    @Nullable
    @UUID(message = "Пример: Идентификатор продукта id = cd874464-19fc-47c5-94c8-34eee9bdae05")
    private String productId;

    @Nullable
    @UUID(message = "Пример: Идентификатор клиента id = cd874464-19fc-47c5-94c8-34eee9bdae05")
    private String customerId;

    private LocalDate fromDate;

    private LocalDate toDate;

}

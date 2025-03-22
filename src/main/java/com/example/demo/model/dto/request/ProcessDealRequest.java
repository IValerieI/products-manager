package com.example.demo.model.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UUID;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class ProcessDealRequest {

    @UUID(message = "Идентификатор продавца обязателен, пример id = cd874464-19fc-47c5-94c8-34eee9bdae05")
    private String sellerId;

    @UUID(message = "Идентификатор клиента обязателен, пример id = cd874464-19fc-47c5-94c8-34eee9bdae05")
    private String customerId;

    @NotBlank
    private String name;

    @Valid
    @NotNull
    private List<ProcessSupplyRequest> supplies;
}

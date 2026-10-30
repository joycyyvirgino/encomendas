package br.com.encomendas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record ItemReceitaRequest(
        @NotNull Long insumoId,
        @NotNull @Positive BigDecimal quantidade) {
}

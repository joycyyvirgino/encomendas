package br.com.encomendas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record EntradaEstoqueRequest(
        @NotNull @Positive BigDecimal quantidade) {
}

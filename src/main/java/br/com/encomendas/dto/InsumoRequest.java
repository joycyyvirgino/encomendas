package br.com.encomendas.dto;

import br.com.encomendas.enums.UnidadeMedida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record InsumoRequest(
        @NotBlank @Size(max = 120) String nome,
        @NotNull UnidadeMedida unidade,
        @NotNull @PositiveOrZero BigDecimal estoqueAtual,
        @NotNull @PositiveOrZero BigDecimal estoqueMinimo) {
}

package br.com.encomendas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemPedidoRequest(
        @NotNull Long produtoId,
        @NotNull @Positive Integer quantidade) {
}

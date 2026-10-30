package br.com.encomendas.dto;

import br.com.encomendas.enums.StatusPedido;
import jakarta.validation.constraints.NotNull;

/** Usado em PATCH /pedidos/{id}/status (somente PRONTO ou ENTREGUE; a regra fica no service). */
public record StatusPedidoRequest(
        @NotNull StatusPedido status) {
}

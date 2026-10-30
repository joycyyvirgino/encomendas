package br.com.encomendas.dto;

import br.com.encomendas.model.ItemPedido;
import java.math.BigDecimal;

public record ItemPedidoResponse(
        Long produtoId,
        String produto,
        int quantidade,
        BigDecimal precoUnitario,
        BigDecimal subtotal) {

    public static ItemPedidoResponse de(ItemPedido i) {
        return new ItemPedidoResponse(
                i.getProduto().getId(),
                i.getProduto().getNome(),
                i.getQuantidade(),
                i.getPrecoUnitario(),
                i.getPrecoUnitario().multiply(BigDecimal.valueOf(i.getQuantidade())));
    }
}

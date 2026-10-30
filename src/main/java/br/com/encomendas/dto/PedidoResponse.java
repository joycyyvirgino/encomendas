package br.com.encomendas.dto;

import br.com.encomendas.enums.StatusPedido;
import br.com.encomendas.model.Pagamento;
import br.com.encomendas.model.Pedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public record PedidoResponse(
        Long id,
        String cliente,
        String telefone,
        StatusPedido status,
        BigDecimal total,
        LocalDate dataEntrega,
        LocalDateTime criadoEm,
        List<ItemPedidoResponse> itens,
        PagamentoResponse pagamento) {

    /** O pagamento exibido é o mais recente do pedido (pode haver cobranças expiradas antes). */
    public static PedidoResponse de(Pedido p) {
        PagamentoResponse ultimo = p.getPagamentos().stream()
                .max(Comparator.comparing(Pagamento::getId))
                .map(PagamentoResponse::de)
                .orElse(null);

        return new PedidoResponse(
                p.getId(),
                p.getCliente(),
                p.getTelefone(),
                p.getStatus(),
                p.getTotal(),
                p.getDataEntrega(),
                p.getCriadoEm(),
                p.getItens().stream().map(ItemPedidoResponse::de).toList(),
                ultimo);
    }
}

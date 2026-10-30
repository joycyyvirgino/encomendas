package br.com.encomendas.dto;

import br.com.encomendas.enums.StatusPagamento;
import br.com.encomendas.model.Pagamento;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoResponse(
        Long id,
        String idExterno,
        BigDecimal valor,
        StatusPagamento status,
        LocalDateTime expiraEm,
        LocalDateTime confirmadoEm) {

    public static PagamentoResponse de(Pagamento p) {
        return new PagamentoResponse(
                p.getId(),
                p.getIdExterno(),
                p.getValor(),
                p.getStatus(),
                p.getExpiraEm(),
                p.getConfirmadoEm());
    }
}

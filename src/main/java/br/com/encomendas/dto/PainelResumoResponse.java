package br.com.encomendas.dto;

import br.com.encomendas.enums.StatusPedido;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public record PainelResumoResponse(
        BigDecimal vendasDoDia,
        Map<StatusPedido, Long> pedidosPorStatus,
        List<InsumoResponse> insumosEmFalta) {
}

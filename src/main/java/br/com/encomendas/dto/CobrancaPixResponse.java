package br.com.encomendas.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Resposta de POST /pedidos/{id}/pagamento. O QR Code vem do Mercado Pago na hora
 * da cobrança e não é persistido, por isso não existe na entidade Pagamento.
 */
public record CobrancaPixResponse(
        Long pagamentoId,
        String idExterno,
        BigDecimal valor,
        LocalDateTime expiraEm,
        String qrCode,
        String qrCodeBase64) {
}
